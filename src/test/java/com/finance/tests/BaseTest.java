package com.finance.tests;

import com.finance.pages.*;
import com.finance.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    FinanceSite financeSite;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get(Constants.URL);
        financeSite = new FinanceSite(driver);
    }

    @AfterMethod
    public void afterMethod() {
        this.driver.quit();
    }
}
