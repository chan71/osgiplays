package org.ck.mytests;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class RestRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("cxfrs:http://0.0.0.0:9090?resourceClasses=org.ck.mytests.CustomerService&bindingStyle=SimpleConsumer")
                .marshal().json(JsonLibrary.Jackson);
    }
}
