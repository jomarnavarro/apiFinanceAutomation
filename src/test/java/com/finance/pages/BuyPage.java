package com.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPage extends BasePage {

    //Login elements
    @FindBy(name="symbol")
    WebElement symbolTxt;

    @FindBy(name="qty")
    WebElement quantityTxt;

    @FindBy(css=".btn")
    WebElement buyBtn;

    public BuyPage(WebDriver driver) {
        super(driver);
    }


    public void comprarAcciones(String symbol, int numAcciones) {
        this.symbolTxt.sendKeys(symbol);
        this.quantityTxt.sendKeys(numAcciones + "");
        this.buyBtn.click();

    }
}
