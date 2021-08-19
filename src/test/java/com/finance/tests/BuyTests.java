package com.finance.tests;

import com.finance.pages.BuyPage;
import com.finance.pages.LoginPage;
import com.finance.pages.MenuPage;
import com.finance.pages.PortfolioPage;
import com.finance.pojo.StockInformation;
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
        String user = "Pedro";
        String password = "Pedro";
        String symbol = "MSFT";
        int numAcciones = 15;
        financeSite.getLoginPage().ingresarCredenciales(user, password);
        financeSite.getPortfolioPage().verificarMensaje("Welcome back " + user);
        StockInformation siBefore = financeSite.getPortfolioPage().getStockInformation(symbol);
        financeSite.getMenuPage().clickBuy();
        financeSite.getBuyPage().comprarAcciones(symbol, numAcciones);
        financeSite.getPortfolioPage().verificarMensaje("You bought " + numAcciones + " share(s) from " + symbol);
        StockInformation siAfter = financeSite.getPortfolioPage().getStockInformation(symbol);
        assertTrue(siBefore.getNumShares() + numAcciones == siAfter.getNumShares());
    }

    @Test
    public void compraSinCredito(){

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
