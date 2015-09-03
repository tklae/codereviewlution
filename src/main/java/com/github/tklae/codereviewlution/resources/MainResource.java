package com.github.tklae.codereviewlution.resources;

import com.codahale.metrics.annotation.Timed;
import lombok.AllArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/start")
@Produces(MediaType.TEXT_PLAIN)
@AllArgsConstructor
public class MainResource {
    private String applicationName;

//    @GET
//    @Timed
//    public String displayStartPage(@QueryParam("name") Optional<String> name) {
//        final String welcomeText = String.format("Welcome to %s", name.or(applicationName));
//        return welcomeText;
//    }

    @GET
    @Timed
    public String displayStartPage() {
        final String welcomeText = String.format("Welcome to %s", applicationName);
        return welcomeText;
    }

}
