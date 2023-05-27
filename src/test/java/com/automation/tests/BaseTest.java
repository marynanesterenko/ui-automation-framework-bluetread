package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.utils.DriverUtils;
import com.automation.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void setUp(Method test) {
        PropertyReader.initProperty();
        DriverUtils.createDriver(test);
        homePage = new HomePage();
    }

    @AfterMethod
    public void cleanUp() {
        DriverUtils.getDriver().quit();
    }
}
