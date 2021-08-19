package com.finance.tests;

import com.finance.pages.LoginPage;
import com.finance.pages.PortfolioPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void happyPathLogin() throws Exception {
        /**
        * en la pagina de login, ingresar credenciales validas(Pedro, Pedro)
        * en la pagina de portafolio, verificar mensaje de bienvenida.
        * en la pagina de portafolio, verificar que existe una tabla con transacciones
        * */
        financeSite.getLoginPage().ingresarCredenciales("Pedro", "Pedro");
        financeSite.getPortfolioPage().verificarMensaje("Welcome back Pedro");
        financeSite.getPortfolioPage().verificarTablaTransacciones("CASH");
    }

    @Test
    public void invalidUsernameLogin() {
        /**
         * en la pagina de login, ingresar credenciales invalidas (pablo, Pedro)
         * en la pagina login, verificar el mensaje "inavlid username and/or password"
         */

        financeSite.getLoginPage().ingresarCredenciales("Pablo" , "Pedro");
        financeSite.getLoginPage().verificarMensaje("invalid username and/or password");

    }

    @Test
    public void invalidPasswordLogin() {
        financeSite.getLoginPage().ingresarCredenciales("Pedro", "Peter");
        String mensajeDesplegado = financeSite.getLoginPage().obtenerMensajeError();
        assertTrue(mensajeDesplegado.equalsIgnoreCase("invalid username and/or password"));
        financeSite.getLoginPage().verificarMensaje("invalid username and/or password");
    }
}
