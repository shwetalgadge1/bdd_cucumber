package stepdefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.LoginPage;
import Pages.ProductPage;
import utils.ExtentReportUtil;
import utils.SeleniumDriver;

public class AutomationExerciseSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = SeleniumDriver.getDriver();
        driver.get("https://www.automationexercise.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("User logs in with valid credentials {string} and {string}")
    public void user_logs_in_with_valid_credentials(String email, String password) {
        loginPage.login(email, password);
    }

    @When("User logs in with invalid credentials {string} and {string}")
    public void user_logs_in_with_invalid_credentials(String email, String password) {
        loginPage.login(email, password);
        boolean isLoginError = loginPage.isLoginErrorDisplayed();
        Assert.assertTrue(isLoginError, "Login error should be displayed.");
        extentReportUtil.captureScreenshot(driver, "InvalidLogin");
    }

    @Then("User clicks on the product section")
    public void user_clicks_on_the_product_section() {
        loginPage.navigateToProducts();
    }

    @Then("User selects all products and prints their names and prices")
    public void user_selects_all_products_and_prints_their_names_and_prices() {
        productPage = new ProductPage(driver);
        productPage.printAllProductNamesAndPrices();
    }

    @Then("User should see login error and take screenshot")
    public void user_should_see_login_error_and_take_screenshot() {
        // Already handled in the invalid login step
    }

    @Then("Extent report is generated with details")
    public void extent_report_is_generated_with_details() {
        extentReportUtil.createTest("Automation Exercise - Invalid Login Test")
                       .assignCategory("Regression Test");  // Assign category if needed
        extentReportUtil.flushReport();
    }

    }

