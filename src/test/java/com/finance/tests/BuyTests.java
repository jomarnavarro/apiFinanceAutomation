package com.finance.tests;

import com.finance.pojo.api.Credentials;
import com.finance.pojo.frontEnd.StockInformation;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class BuyTests extends BaseTest {

    @Test
    public void compraExitosa() throws Exception {
        /**
         * en la pagina de login, ingresar credenciales
         * en la pagina de portafolio verificar el mensaje de bienvenida
         * en la pagina de menu, doy click en 'Buy'
         * en la pagina de buy, ingresar simbolo y cantidad y click en buy
         * en la pagina de portafolio, verificar el mensaje de compra
         * en la pagina de portafolio, verificar que el simbolo tiene x acciones
         */

        String symbol = "MSFT";
        int numAcciones = 15;
        financeSite.getLoginPage().ingresarCredenciales(credentials.getUsername(), credentials.getPassword());
        financeSite.getPortfolioPage().verificarMensaje("Welcome back " + credentials.getUsername());
        StockInformation siBefore = financeSite.getPortfolioPage().getStockInformation(symbol);
        financeSite.getMenuPage().clickBuy();
        financeSite.getBuyPage().comprarAcciones(symbol, numAcciones);
        financeSite.getPortfolioPage().verificarMensaje("You bought " + numAcciones + " share(s) from " + symbol);
        StockInformation siAfter = financeSite.getPortfolioPage().getStockInformation(symbol);
        assertTrue(siBefore.getNumShares() + numAcciones == siAfter.getNumShares());
    }

    @Test
    public void compraSinCredito() throws Exception {
//        Setup

        financeApi.loginEndpoint().login(credentials.getUsername(), credentials.getPassword());
        financeApi.buyEndpoint().buyStock("MSFT", 30);
        //Caso de prueba
        String symbol = "AMZN";
        int numAcciones = 1;
        financeSite.getLoginPage().ingresarCredenciales(credentials.getUsername(), credentials.getPassword());
        financeSite.getPortfolioPage().verificarMensaje("Welcome back " + credentials.getUsername());
        StockInformation siBefore = financeSite.getPortfolioPage().getStockInformation(symbol);
        financeSite.getMenuPage().clickBuy();
        financeSite.getBuyPage().comprarAcciones(symbol, numAcciones);
        financeSite.getPortfolioPage().verificarMensaje("short for this transaction.");
//        StockInformation siAfter = financeSite.getPortfolioPage().getStockInformation(symbol);
//        assertTrue(siBefore.getNumShares() + numAcciones == siAfter.getNumShares());

    }

    @Test
    public void compraConSimboloInvalido(){

    }
    @Test

    public void compraConCantidadIncorrecta() {

    }
    @Test
    public void compraConCamposVacios(){

    }
}
