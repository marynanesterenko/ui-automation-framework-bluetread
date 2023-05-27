package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(css = "#number")
    WebElement inputField;

    @FindBy(css = "#getFactorial")
    WebElement calculateButton;

    public void openWebsite() {
        driver.get(PropertyReader.getProperty("application.url"));
    }

    public void verifyTitle(String title) {
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = PropertyReader.getProperty("page.title");
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    public void enterNumber(String s) {
        inputField.sendKeys();

    }

    public void verifyResultCorrectness() {
    }
}
