package com.medasoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by isurud on 4/28/14.
 */
public class DateUtil {


    public static String convertToSimpleDate(String complexDate){
        final String OLD_FORMAT = "EEE MMM dd hh:mm:ss Z yyyy";
        final String NEW_FORMAT = "yyyy-MM-dd";

        String newDateString;

        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = null;
        System.out.println("receive date "+complexDate);
        try {
            d = sdf.parse(complexDate);
            System.out.println("Parse Success");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Parse Failed ");
        }
        sdf.applyPattern(NEW_FORMAT);
        System.out.println("Pattern Applied");
        newDateString = sdf.format(d);
        return  newDateString;
    }

}
