package com.vn.quarkus.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient(configKey="service-two")
public interface GreetingService {

    @GET
    @Path("/direct")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloDirect();
    
}