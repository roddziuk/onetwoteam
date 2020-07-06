package org.odindvateam;

import static org.junit.Assert.assertTrue;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/json/results.json","html:target/html/results.html"},
        features = {"src/test/java/org/odindvateam/odindvateamhome.feature"},
        glue = {"org.odindvateam"}
)
public class AppTest 
{
}
