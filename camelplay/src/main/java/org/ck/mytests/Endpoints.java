package org.ck.mytests;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.jaxrs.CxfRsEndpoint;
import org.apache.camel.component.file.FileEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by ck40283 on 4/16/15.
 */
public class Endpoints {

    private static final Logger LOG = LoggerFactory.getLogger(Endpoints.class);

    public static void main(String[] args) throws Exception {

        final CamelContext context = new DefaultCamelContext();

        LOG.trace("about to create camel context");
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("cxfrs://http://localhost:8095/com?resourceClasses=" + CompanyService.class.getName())
                        .marshal().json(JsonLibrary.Jackson);
                from("cxfrs://http://localhost:8095/cus?resourceClasses=" + CustomerService.class.getName())
                        .marshal().json(JsonLibrary.Jackson);

            }
        });

        context.start();

        Thread.sleep(60*1000);

        context.stop();
    }
}
