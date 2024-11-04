package com.cagara.postmanApi.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumberhtml-reports.html"
        },
        features = "src/test/java/com/cagara/postmanApi/features",
        glue = {"com/cagara/postmanApi/steps"},
        monochrome = true)
public class SampleApiTests {
}
