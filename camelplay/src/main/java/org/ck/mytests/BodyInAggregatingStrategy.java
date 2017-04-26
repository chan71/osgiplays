package org.ck.mytests;

import org.apache.camel.Exchange;
import org.apache.camel.Property;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Created by ck40283 on 4/24/15.
 */
public class BodyInAggregatingStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);
        oldExchange.getIn().setBody(oldBody + "+" + newBody);
        return oldExchange;
    }

    /**
     * An expression used to determine if the aggregation is complete
     */
    public boolean isCompleted(@Property(Exchange.AGGREGATED_SIZE) Integer aggregated) {
        if (aggregated == null) {
            return false;
        }

        return aggregated == 3;
    }

}
