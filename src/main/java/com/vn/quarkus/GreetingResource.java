package com.vn.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.vn.quarkus.service.GreetingService;

@Path("/hello")
@RegisterRestClient(configKey="service-two")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello from service one";
    }
    
    @Inject
    @RestClient
    GreetingService greetingService;
	
	@GET
	@Path("/direct")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloDirect() {
		return "hello from service one\n" + greetingService.helloDirect();
	}
}