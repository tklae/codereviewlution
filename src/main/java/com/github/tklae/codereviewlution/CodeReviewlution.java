package com.github.tklae.codereviewlution;

import com.github.tklae.codereviewlution.healthchecks.StartupHealthcheck;
import com.github.tklae.codereviewlution.resources.MainResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class CodeReviewlution extends Application<ServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new CodeReviewlution().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        MainResource mainResource = new MainResource(
                configuration.getAppName()
        );
        environment.jersey().register(mainResource);

        StartupHealthcheck startupHealthcheck = new StartupHealthcheck(mainResource);
        environment.healthChecks().register("startup", startupHealthcheck);
    }
}
