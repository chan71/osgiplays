package org.ck.mytests.mqtt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ck40283 on 4/7/15.
 */
public class DateFormatTest {

    public static void main(String[] args) {

        solution1();
        solution2();

    }

    private static void solution1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(new Date());
        try {
            String d = sdf.format(new Date());
            System.out.println(d);
            System.out.println(sdf.parse(d));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private static void solution2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(new Date());

        SimpleDateFormat sdfLocal = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");


        try {
            String d = sdf.format(new Date());
            System.out.println(d);
            System.out.println(sdfLocal.parse(d));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
