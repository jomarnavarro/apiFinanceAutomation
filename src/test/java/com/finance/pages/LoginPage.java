package com.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends BasePage {


    //Login elements
    @FindBy(name="username")
    WebElement usernameTxt;

    @FindBy(name="password")
    WebElement passwordTxt;

    @FindBy(css=".btn")
    WebElement loginBtn;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarCredenciales(String user, String password) {

        usernameTxt.sendKeys(user);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }

    public void verificarMensajeError(String mensajeError) {
        wait.until(ExpectedConditions.visibilityOf(this.mensajeLbl));
        assertTrue("Mensaje es incorrecto", this.mensajeLbl.getText().contains(mensajeError));
    }


    public String obtenerMensajeError() {
        wait.until(ExpectedConditions.visibilityOf(this.mensajeLbl));
        return this.mensajeLbl.getText();
    }

    public void verificarMensaje(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(this.mensajeLbl));
        assertTrue("Mensaje erroneo", this.mensajeLbl.getText().contains(mensaje));
    }
}
