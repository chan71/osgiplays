package org.ck.mytests.mqtt;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;

/**
 * Created by ck40283 on 11/6/14.
 */
public class TimestampTest {

    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );
        DateTime start = new DateTime();
        Thread.sleep(1000);
        Period period = new Period(new DateTime(), start);

        System.out.println(PeriodFormat.getDefault().print(period));
    }
}
