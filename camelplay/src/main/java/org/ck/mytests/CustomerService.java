package org.ck.mytests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by ck40283 on 6/6/15.
 */
@Path("/customer")
public interface CustomerService {
    @GET
    @Path("/customers/{id}/")
    String getCustomer(@PathParam("id") String id);
}
