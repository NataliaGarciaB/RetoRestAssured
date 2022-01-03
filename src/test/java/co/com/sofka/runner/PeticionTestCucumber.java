package co.com.sofka.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/get_delete.feature"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "co.com.sofka.stepdefinition",
        publish = true
)
public class PeticionTestCucumber {
}
