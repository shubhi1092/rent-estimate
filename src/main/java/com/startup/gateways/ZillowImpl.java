package com.startup.gateways;

import com.startup.common.CurrencyValue;
import com.startup.model.RentRange;
import com.startup.generated.zillow.Amount;
import com.startup.generated.zillow.Searchresults;
import com.startup.generated.zillow.SimpleProperty;
import com.startup.generated.zillow.Zestimate;
import com.startup.generated.zillow.Zestimate.ValuationRange;
import org.springframework.lang.NonNull;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.math.BigInteger;
import java.net.*;
import java.util.Currency;

public class ZillowImpl {

    private static final String zwsID = "X1-ZWz1gcwe19m96z_89sjr";
    private static final String baseUrl = "http://www.zillow.com/webservice/GetSearchResults.htm";

    public RentRange fetchRentEstimate(String address){
        RentRange rentRange = null;
        try {
            String url = String.format("%s?zws-id=%s&address=%s&citystatezip=%s&rentzestimate=true", baseUrl, zwsID, URLEncoder.encode(address, "UTF-8"), "94105");
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
                    rentRange = convertValuationToRentRange(rentEstimateValuationRange);
                } else {
                    Amount amount = zestimate.getAmount();
                    BigInteger rentEstimate = amount.getValue().multiply(BigInteger.valueOf((long)0.05));
                    BigInteger rentEstimateUpperBound = rentEstimate.multiply(BigInteger.valueOf((long)1.1));
                    BigInteger rentEstimateLowerBound = rentEstimate.multiply(BigInteger.valueOf((long)0.9));
                    Currency currency = convertZillowCurrencyToCurrency(amount.getCurrency());
                    CurrencyValue lowerBound = new CurrencyValue(currency, rentEstimateLowerBound);
                    CurrencyValue upperBound = new CurrencyValue(currency, rentEstimateUpperBound);
                    rentRange = new RentRange(lowerBound, upperBound);
                }
            }

            con.disconnect();
        } catch(Exception e){
        }

        return rentRange;
    }

    private RentRange convertValuationToRentRange(@NonNull ValuationRange valuationRange) {
        Amount low = valuationRange.getLow();
        Amount high = valuationRange.getHigh();
        return new RentRange(convertAmountToCurrencyValue(low), convertAmountToCurrencyValue(high));
    }

    private CurrencyValue convertAmountToCurrencyValue(@NonNull Amount amount) {
        Currency currency = convertZillowCurrencyToCurrency(amount.getCurrency());
        return new CurrencyValue(currency, amount.getValue());
    }

    private Currency convertZillowCurrencyToCurrency(@NonNull com.startup.generated.zillow.Currency zillowCurrency) {
        Currency currency = Currency.getInstance(zillowCurrency.value());
        return currency;
    }
}
