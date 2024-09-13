package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\workspace for cucucmber\\Cucumber_bdd\\src\\test\\resources\\Features",// Path to the feature files
        glue = {"stepdefinations"}, // Path to the step definitions
        plugin = {
                "pretty", // For readable console output
                "html:target/cucumber-reports/cucumber.html", 
                "json:target/cucumber-reports/cucumber.json", // JSON report generation
                "junit:target/cucumber-reports/cucumber.xml" 
        },
        monochrome = true, // To make the console output more readable
        tags = "@login" // You can specify tags to run specific scenarios
)

public class TestRunner {
    
   
    }

