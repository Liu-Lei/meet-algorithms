package com.liulei.qunarspider;

import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 7/9/13
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class QunarSpider {
    public static void main(String[] args) {
        String qunar = "http://flight.qunar.com/site/oneway_list.htm?searchDepartureAirport=%E5%93%88%E5%B0%94%E6%BB%A8&searchArrivalAirport=%E5%B9%BF%E5%B7%9E&searchDepartureTime=2013-07-10&searchArrivalTime=2013-07-10&nextNDays=0&startSearch=true&from=qunarindex&sd_idx=1&SearchLocation=sevenday_search";

        String qunar2 = "http://flight.qunar.com/twell/flight/DynamicFlightInfo.jsp?&departureCity=%E5%93%88%E5%B0%94%E6%BB%A8&arrivalCity=%E5%B9%BF%E5%B7%9E&departureDate=2013-07-09&fromCity=%E5%93%88%E5%B0%94%E6%BB%A8&toCity=%E5%B9%BF%E5%B7%9E&from=qunarindex";
        try {
            URLConnection connection = new URL(qunar).openConnection();
            Parser parser = new Parser(connection);
            TextExtractingVisitor visitor = new TextExtractingVisitor();
            parser.visitAllNodesWith(visitor);
            String textInPage = visitor.getExtractedText();

            System.out.println(textInPage);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
