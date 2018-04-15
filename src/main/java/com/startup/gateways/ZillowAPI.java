package com.startup.gateways;

import com.startup.generated.zillow.Searchresults;
import com.startup.generated.zillow.SimpleProperty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.*;

public class ZillowAPI {

    private static final String zws_id = "X1-ZWz1gcwe19m96z_89sjr";
    private static final String api = "http://www.zillow.com/webservice/GetSearchResults.htm?";

    /**
     * Calls Zillow API given address
     * @param address
     * @param citystatezip
     * @param rentzestimste
     */
    public SimpleProperty callAPI(String address, String citystatezip, boolean rentzestimste){

        String url = api+"zws-id="+zws_id+"&address="+address+"&citystatezip="+citystatezip+"&rentzestimate="+rentzestimste;
        SimpleProperty list = new SimpleProperty();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println(responseCode);

            if(responseCode==200){
                JAXBContext jaxbContext = JAXBContext.newInstance(Searchresults.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Searchresults result = (Searchresults) jaxbUnmarshaller.unmarshal(con.getInputStream());
                list = result.getResponse().getResults().getResult().get(0);
            }

            con.disconnect();
        } catch(Exception e){

        }
        return list;
    }
}
