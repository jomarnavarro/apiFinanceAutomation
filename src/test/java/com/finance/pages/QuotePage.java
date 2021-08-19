package com.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotePage extends BasePage {

    @FindBy(name="symbol")
    WebElement symbolTxt;

    @FindBy(css=".btn")
    WebElement quoteBtn;

    public QuotePage(WebDriver driver) {
        super(driver);
    }
}
