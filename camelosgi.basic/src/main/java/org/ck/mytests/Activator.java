package org.ck.mytests;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.core.osgi.OsgiDefaultCamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by ck40283 on 4/17/15.
 */
public class Activator implements BundleActivator {

    private final static Logger logger = LoggerFactory.getLogger(Activator.class);

    CamelContext camelContext = null;

    public void start(BundleContext bundleContext) throws Exception {

        logger.info("Start bundle now.");
        camelContext = new OsgiDefaultCamelContext(bundleContext);
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                Processor simpleDateAdder = new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Message inMessage = exchange.getIn();
                        inMessage.setBody(new Date().toString() + "\n" + inMessage.getBody(String.class));
                        logger.info("Body content: " + exchange.getIn().getBody());
                    }
                };
                from("file:/data/tmp/in?noop=true").process(simpleDateAdder).to("file:/data/tmp/out");
            }
        });
        camelContext.start();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        logger.info("Stop bundle now.");
        camelContext.stop();
    }
}
