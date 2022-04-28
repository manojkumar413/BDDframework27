package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(
        features = ("src/test/java/features"),
        glue = ("steps"),
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/html-reports/report.html", "junit:target/xml-reports/report.xml", "json:target/json-reports/report.json"},
        tags = ("@Negative"),
        
        monochrome = true,
        publish = true,
        dryRun = false
          )

public class Runner {

}
