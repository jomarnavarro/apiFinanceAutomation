package com.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {

    @FindBy(linkText = "Log In")
    WebElement loginLnk;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Quote")
    WebElement quoteLink;

    @FindBy(linkText = "Buy")
    WebElement buyLink;

    @FindBy(linkText = "Sell")
    WebElement sellLink;

    @FindBy(linkText = "History")
    WebElement historyLink;

    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickBuy() {
        this.buyLink.click();

    }
}
