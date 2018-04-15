package com.startup;

import com.startup.gateways.ZillowAPI;
import com.startup.generated.zillow.Amount;
import com.startup.generated.zillow.SimpleProperty;
import com.startup.generated.zillow.Zestimate;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class RentEstimate {


    public List<Amount> getEstimate(String address, String city, String state, String zip){

        List<Amount> amount = new ArrayList<>();
        String citystatezip="";
        if(city==null || state==null){
            citystatezip=zip;
        }
        else if(zip==null || zip.length()==0){
            citystatezip=city+" "+state;
        }
        else{
            citystatezip=city+" "+state+" "+zip;
        }
        try {
            address = URLEncoder.encode(address, "UTF-8");
            citystatezip = URLEncoder.encode(citystatezip, "UTF-8");
        } catch(Exception e){

        }
        boolean rentzestimate=true;

        ZillowAPI zapi = new ZillowAPI();
        SimpleProperty result = zapi.callAPI(address, citystatezip, rentzestimate);

        Zestimate rent = result.getRentzestimate();
        if(rent!=null){
            Zestimate.ValuationRange range = rent.getValuationRange();
            amount.add(range.getHigh());
            amount.add(range.getLow());
        }
        else{
            Zestimate z = result.getZestimate();
            Amount price = z.getAmount();

            BigInteger annual_rent = price.getValue().multiply(BigInteger.valueOf((long)0.05));
            BigInteger high = annual_rent.add(annual_rent.multiply(BigInteger.valueOf((long)0.1)));
            BigInteger low = annual_rent.subtract(annual_rent.multiply(BigInteger.valueOf((long)0.1)));
            Amount h = new Amount();
            h.setValue(high);
            h.setCurrency(price.getCurrency());
            Amount l = new Amount();
            l.setValue(low);
            l.setCurrency(price.getCurrency());
            amount.add(h);
            amount.add(l);
        }
        return amount;
    }
}
