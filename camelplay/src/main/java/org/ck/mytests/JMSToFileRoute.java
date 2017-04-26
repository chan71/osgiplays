package org.ck.mytests;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by ck40283 on 4/16/15.
 */
public class JMSToFileRoute {
    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("mqtt:comp_name?subscribeTopicName=camel.test&host=tcp://iot.eclipse.org:1883").to("log:JMSToFile?level=DEBUG").to("file:/data/tmp/out");
            }
        });

        context.start();

        Thread.sleep(60*1000);

        context.stop();
    }
}
