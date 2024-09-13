package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    @FindBy(css = ".product-name")
    List<WebElement> productNames;

    @FindBy(css = ".product-price")
    List<WebElement> productPrices;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printAllProductNamesAndPrices() {
        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i).getText();
            String price = productPrices.get(i).getText();
            System.out.println("Product: " + name + " | Price: " + price);
        }
    }
}
