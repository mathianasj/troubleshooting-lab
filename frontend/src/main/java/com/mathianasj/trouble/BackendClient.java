package com.mathianasj.trouble;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
@RegisterRestClient(configKey = "backend")
public interface BackendClient {
    @GET
    Uni<String> sayHello();
}
