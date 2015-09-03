package com.github.tklae.codereviewlution.healthchecks;

import com.codahale.metrics.health.HealthCheck;
import com.github.tklae.codereviewlution.resources.MainResource;
import lombok.AllArgsConstructor;

/**
 * Makes sure the start page is displayed correctly
 */
@AllArgsConstructor
public class StartupHealthcheck extends HealthCheck {

    private MainResource mainResource;

    @Override
    protected Result check() throws Exception {
        String expectedText = "Welcome to CodeReviewlution";
        String actualText = mainResource.displayStartPage();

        if(expectedText.equals(actualText)) {
            return Result.healthy();
        }
        return Result.unhealthy(String.format("Expected: %s, Was: %s", expectedText, actualText));
    }
}
