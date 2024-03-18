package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber", glue ="automation.stepDefinitions",monochrome = true,tags = "@ErrorValidations",
plugin= {"html:target/cucmber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}
