package com.mathianasj.backend;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Path("/hello")
public class HelloLogger {
    @GET
    public String echo() {
        try {
            File dir = new File("/create/mount/here");
            File f = File.createTempFile("present", ".txt", dir);
            FileWriter fileWriter = new FileWriter(f.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write("testing");
            bw.close();
        } catch(IOException ex) {
            throw new RuntimeException("could not write temporary file to /create/mount/here", ex);
        }

            return "Hello";
    }
}
