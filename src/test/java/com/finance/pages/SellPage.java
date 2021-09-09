package com.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellPage extends BasePage {

    @FindBy( name="symbol")
    WebElement symbolTxt;

    @FindBy (name="qty")
    WebElement quantityTxt;

    @FindBy(css = ".btn")
    WebElement sellBtn;

    public SellPage(WebDriver driver) {
        super(driver);
    }

    public void sellStock(String symbol, String qty) {
        //instrucciones de selenium
    }

}
