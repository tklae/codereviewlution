package com.github.tklae.codereviewlution;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class ServiceConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String appName = "undefined";
}
