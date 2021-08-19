package com.finance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellPage {

    @FindBy( name="symbol")
    WebElement symbolTxt;

    @FindBy (name="qty")
    WebElement quantityTxt;

    @FindBy(css = ".btn")
    WebElement sellBtn;

}
