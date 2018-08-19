

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:build/cucumber",
                "json:build/cucumber.json",
                "junit:build/cucumber.xml",
                "html:target/cucumber",
                "pretty"
        },
        features = {"src/test/java/feature/"},
        tags = {"@de"},
        strict = false,
        glue = {"step"}

)

public class Runner {
}



