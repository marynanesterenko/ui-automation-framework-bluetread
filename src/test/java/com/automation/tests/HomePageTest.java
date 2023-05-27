package com.automation.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class HomePageTest extends BaseTest {

    @FindBy(xpath = "//input[@id='number']")
    WebElement inputField;

    @FindBy(css = "#getFactorial")
    WebElement calculateBtn;

    @FindBy(css = "#resultDiv")
    WebElement calculatedResult;

    @Test
    public void verifyHomePage() {
        homePage.openWebsite();
//        String title = DriverUtils.getDriver().getTitle();
//        Assert.assertEquals(title, "Factorial");

    }

    @DataProvider(name = "entries")
    public Object[] provideEntries() {
        return new Object[]{0, 1, 5, 10, 55};
    }

    @Test(dataProvider = "entries")
    public void verifyFactorialCalculation(int number) {

        String entry = String.valueOf(number);
        inputField.sendKeys(entry);
        calculateBtn.click();

        String actResult = calculatedResult.getText();

        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }

        String expResult = "The factorial of " + number + " is: " + result;
        Assert.assertEquals(actResult, expResult);
    }

}
