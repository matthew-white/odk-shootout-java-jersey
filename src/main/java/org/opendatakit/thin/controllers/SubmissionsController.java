package org.opendatakit.thin.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/submission")
public class SubmissionsController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSubmissions() {
        return "get submissions";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // TODO: Switch from query parameter to path parameter.
    public String getSubmission(@QueryParam("id") long id) {
        return "get submission";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("id") String id,
        @FormParam("xml") String xml) {
        System.out.println("create submission");
    }
}
