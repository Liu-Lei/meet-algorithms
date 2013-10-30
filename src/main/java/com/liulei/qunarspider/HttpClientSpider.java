package com.liulei.qunarspider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 7/10/13
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientSpider {

    public  static String qunar = "http://flight.qunar.com/site/oneway_list.htm?searchDepartureAirport=%E5%93%88%E5%B0%94%E6%BB%A8&searchArrivalAirport=%E5%B9%BF%E5%B7%9E&searchDepartureTime=2013-07-10&searchArrivalTime=2013-07-10&nextNDays=0&startSearch=true&from=qunarindex&sd_idx=1&SearchLocation=sevenday_search";

    public static void main(String[] args) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(qunar);

        HttpResponse httpResponse = httpClient.execute(httpGet);

        try {
            System.out.println(httpResponse.getStatusLine());

            HttpEntity entity1 = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(entity1));
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
        } finally {
            httpGet.releaseConnection();
        }

    }
}
