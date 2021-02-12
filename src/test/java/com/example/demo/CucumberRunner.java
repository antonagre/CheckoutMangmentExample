package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dove si trova il gherkin
        features = "src/test/resources",
        //dove si torovano gli step java
        glue = "com.example.demo.steps",
        plugin = {"json:target/cucumber.json"}
)
public class CucumberRunner {
}