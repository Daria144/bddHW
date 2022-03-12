package selenide.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
glue = "selenide/steps"
)
public class TestRunner extends AbstractTestNGCucumberTests { }