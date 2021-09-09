package com.finance.tests;

import com.finance.pojo.api.Credentials;
import com.finance.pojo.frontEnd.StockInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellTests extends BaseTest{

    @Test
    public void testSellSuccesful() throws Exception {
//  Setup
        financeApi.loginEndpoint().login(credentials.getUsername(), credentials.getPassword());
        financeApi.buyEndpoint().buyStock("MSFT", 30);
        //caso de prueba
        financeSite.getLoginPage().ingresarCredenciales(credentials.getUsername(), credentials.getPassword());
        financeSite.getPortfolioPage().verificarMensaje("Welcome back " + credentials.getUsername());
        StockInformation siBefore = financeSite.getPortfolioPage().getStockInformation("MSFT");
        financeSite.getMenuPage().clickSell();
        financeSite.getSellPage().sellStock("MSFT", "15");
        financeSite.getPortfolioPage().verificarMensaje("You sold 15 share(s) from MSFT");
        StockInformation siAfter = financeSite.getPortfolioPage().getStockInformation("MSFT");
        Assert.assertTrue(siBefore.getNumShares() - 15 == siAfter.getNumShares());
    }

    @Test
    public void testSellInvalidQuantity(){

    }

    @Test
    public void testSellInvalidEmptyQuantityField(){

    }

    @Test
    public void testSellMoreSharesThanAvailable(){

    }

    @Test
    public void testSellEmptySymbol(){

    }


}
