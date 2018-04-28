package com.startup.gateways;

import com.startup.model.RentRange;
import com.startup.generated.zillow.Amount;
import com.startup.generated.zillow.Searchresults;
import com.startup.generated.zillow.SimpleProperty;
import com.startup.generated.zillow.Zestimate;
import org.springframework.lang.NonNull;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.math.BigInteger;
import java.net.*;
import java.util.Currency;

public class ZillowImpl {

    private static final String zwsID = "X1-ZWz1gcwe19m96z_89sjr";
    private static final String baseUrl = "http://www.zillow.com/webservice/GetSearchResults.htm";

    public RentRange fetchRentEstimate(String address, int zipcode){
        RentRange rentRange = null;
        try {
            String url = String.format("%s?zws-id=%s&address=%s&citystatezip=%d&rentzestimate=true", baseUrl, zwsID, URLEncoder.encode(address, "UTF-8"), zipcode);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if(responseCode==200){
                JAXBContext jaxbContext = JAXBContext.newInstance(Searchresults.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Searchresults result = (Searchresults) jaxbUnmarshaller.unmarshal(con.getInputStream());
                SimpleProperty property = result.getResponse().getResults().getResult().get(0);

                Zestimate rentZestimate = property.getRentzestimate();
                Zestimate zestimate = property.getZestimate();
                if(rentZestimate != null) {
                    Zestimate.ValuationRange rentEstimateValuationRange = rentZestimate.getValuationRange();
                    Currency currency = convertZillowCurrencyToCurrency(rentZestimate.getAmount().getCurrency());
                    Amount low = rentEstimateValuationRange.getLow();
                    Amount high = rentEstimateValuationRange.getHigh();
                    rentRange = new RentRange(currency, low.getValue().intValue(), high.getValue().intValue());
                } else {
                    Amount amount = zestimate.getAmount();
                    BigInteger rentEstimate = amount.getValue().multiply(BigInteger.valueOf((long)0.05));
                    BigInteger rentEstimateUpperBound = rentEstimate.multiply(BigInteger.valueOf((long)1.1));
                    BigInteger rentEstimateLowerBound = rentEstimate.multiply(BigInteger.valueOf((long)0.9));
                    Currency currency = convertZillowCurrencyToCurrency(amount.getCurrency());
                    rentRange = new RentRange(currency, rentEstimateLowerBound.intValue(), rentEstimateUpperBound.intValue());
                }
            }

            con.disconnect();
        } catch(Exception e){
        }

        return rentRange;
    }

    private Currency convertZillowCurrencyToCurrency(@NonNull com.startup.generated.zillow.Currency zillowCurrency) {
        Currency currency = Currency.getInstance(zillowCurrency.value());
        return currency;
    }
}
