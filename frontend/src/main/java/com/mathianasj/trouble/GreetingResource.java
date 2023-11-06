package com.mathianasj.trouble;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/status")
public class GreetingResource {
    @Inject
    Template index;

    @RestClient
    BackendClient client;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Uni<TemplateInstance> hello() {
        // String resp = client.sayHello();
        // String status = resp.equals("Hello") ? "Up" : "down";
        // return index.data("status", status);

        return client.sayHello().onFailure()
        .recoverWithItem(e -> {
            return "down";
        })
        .map(s -> {
            String status = s.equals("Hello") ? "up" : "down";

            return index.data("status", status);
        });
    }
}
