package org.ck.mytests.mqtt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ck40283 on 11/6/14.
 */
public class TimestampTest {

/*    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );
        DateTime start = new DateTime();
        Thread.sleep(1000);
        Period period = new Period(new DateTime(), start);

        System.out.println(PeriodFormat.getDefault().print(period));
    }*/

    public static void main( String[] args ) throws Exception {

        String timestamp = "2015-01-19T07:20:00.000Z";
        Date deviceTimestamp;
        Date threshold = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); //2014-07-01T07:34:29.000Z
        dateFormat.setTimeZone(TimeZone.getTimeZone("Zulu"));
        try {
            deviceTimestamp = dateFormat.parse(timestamp);
            threshold.setTime(threshold.getTime() - 600000);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new Exception("");
        }
        boolean result = deviceTimestamp.after(threshold);
        System.out.println("result is : " + result);
    }
}
