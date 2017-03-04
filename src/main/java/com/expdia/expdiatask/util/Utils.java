/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expdia.expdiatask.util;

import com.expdia.expdiatask.beans.RequestSearchBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author ahmad
 */
public class Utils {

   private static final String currentDateFormat = "MM/dd/yyyy";
   private static final String newDateFormat = "yyyy-MM-dd";
    public static String URL_EXPDIA = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationName=#DESTINATION_NAME#&minTripStartDate=:#MINTRIP_START_DATE#&maxTripStartDate=:#MAXTRIP_START_DATE#";
/**
 * 
 * @param req
 * @return RequestSearchBean
 */
    public static RequestSearchBean getBeanRequest(HttpServletRequest req) throws ParseException {
        
        SimpleDateFormat dtFormat = new SimpleDateFormat(currentDateFormat);
        
        Date sDate = dtFormat.parse(req.getParameter("minTripStartDate"));
        Date eDate=dtFormat.parse(req.getParameter("maxTripStartDate"));
        
        dtFormat.applyPattern(newDateFormat);

        System.out.println("start :"+dtFormat.format(sDate)+"end : "+dtFormat.format(eDate)+"\n");
        
        RequestSearchBean requestSearchObj = new RequestSearchBean();
        requestSearchObj.setCity(req.getParameter("city"));
        requestSearchObj.setStartDate(dtFormat.format(sDate));
        requestSearchObj.setEndDate(dtFormat.format(eDate));
        System.out.println("requestSearchObj :"+requestSearchObj.toString());
        
        return requestSearchObj;
    }
/**
 * 
 * @param url
 * @return Json 
 */
    public static String httpCall(String url) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            System.out.println("Received GET JSON Result : " + json);

            return json;

        } catch (Exception e) {
            System.out.println("Error Getting JSON Data" + e);
            return "ERROR";
        }
    }

    /**
     *
     * @param objSearch
     * @return URL_EXPDIA
     */
    public static String getURLExpdia(RequestSearchBean objSearch,String url) {
//       String urlEspdia=URL_EXPDIA;
       String replaceURL = url.replace("#DESTINATION_NAME#", objSearch.getCity()).replace("#MINTRIP_START_DATE#", objSearch.getStartDate()).replace("#MAXTRIP_START_DATE#", objSearch.getEndDate()).replace("#DESTINATION_NAME#", objSearch.getCity()).replace("#MINTRIP_START_DATE#", objSearch.getStartDate()).replace("#MAXTRIP_START_DATE#", objSearch.getEndDate());
        System.out.println("com.expdia.expdiatask.util.Utils.getURLExpdia() new  URL replace : "+replaceURL);
        return replaceURL;
    }

}
