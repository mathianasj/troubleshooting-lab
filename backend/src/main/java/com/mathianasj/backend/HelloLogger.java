package com.mathianasj.backend;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.io.File;

@Path("/hello")
public class HelloLogger {
    @GET
    public String echo() {
        File f = File.createTempFile("/create/mount/here", "txt");

        return "Hello";
    }
}
