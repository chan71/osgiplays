package org.ck.mytests;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by ck40283 on 4/16/15.
 */
public class ComplexRoute {



    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:foo")
                        .streamCaching()
                        .log(LoggingLevel.INFO, "inside route")
                        .wireTap("direct:tapped")
                            .newExchange(
                                    new Processor() {
                                        @Override
                                        public void process(Exchange exchange) throws Exception {
                                            exchange.getIn().setBody("my new message");
                                            exchange.getIn().setHeader("first", "sample header value");
                                        }
                                    })
                        .log(LoggingLevel.INFO, "${body}")
                        .setBody(simple(
                                "<books> <book> <genre>fiction</genre> </book> <book> <genre>romance</genre> </book> <book> <genre>fiction</genre> </book> </books>"))
                        .setBody().xpath("/books/book/genre[text()='fiction']")
                        .log(LoggingLevel.INFO, "${body}")
                        .split().tokenizeXML("genre", "books")
                        .log(LoggingLevel.INFO, "split contents : ${body}")
                        .choice()
                            .when(body().contains("fiction")).log(LoggingLevel.INFO, "fiction")
                        .when(body().contains("fiction")).log(LoggingLevel.INFO, "romance")
                        .otherwise().log(LoggingLevel.INFO, "not fiction or romance")
                        .end()
                        .aggregate(constant(true), new BodyInAggregatingStrategy()).completionSize(3)
                        .log(LoggingLevel.INFO, "aggregated contents : ${body}")
                        .to("mock:result");
                from("direct:tapped").log(LoggingLevel.INFO, "message body : '${body}' and message headers : '${headers.first}'");
            }
        });

        context.start();

        ProducerTemplate producer = context.createProducerTemplate();
        producer.sendBody("direct:foo", "initial message");

        Thread.sleep(20*1000);

        context.stop();
    }
}
