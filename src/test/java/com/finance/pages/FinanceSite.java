package com.finance.pages;

import org.openqa.selenium.WebDriver;

public class FinanceSite {
    private final WebDriver driver;
    LoginPage loginPage;
    PortfolioPage portfolioPage;
    BuyPage buyPage;
    MenuPage menuPage;

    public FinanceSite(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(this.driver);
    }

    public PortfolioPage getPortfolioPage() {
        return new PortfolioPage(this.driver);
    }

    public BuyPage getBuyPage() {
        return new BuyPage(this.driver);
    }
    public MenuPage getMenuPage() {
        return new MenuPage(this.driver);
    }
    public SellPage getSellPage() {
        return new SellPage(this.driver);
    }


}
