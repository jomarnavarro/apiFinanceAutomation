package com.finance.tests;

import com.finance.api.FinanceApi;
import com.finance.pages.*;
import com.finance.pojo.api.Credentials;
import com.finance.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    FinanceSite financeSite;
    FinanceApi financeApi;
    Credentials credentials;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        driver = new ChromeDriver();
        driver.get(Constants.URL);
        financeSite = new FinanceSite(driver);
        financeApi = new FinanceApi(Constants.URL);
        financeApi.loginEndpoint().login(Constants.ADMIN_USER, Constants.ADMIN_PASSWORD);
        credentials = financeApi.registerEndpoint().registerNewUser();
    }

    @AfterMethod
    public void afterMethod() {
        this.driver.quit();
    }
}
