package com.finance.pages;

import com.finance.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = ".alert")
    WebElement mensajeLbl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Constants.SHORT_WAIT);
        PageFactory.initElements(this.driver, this);
    }
    public void verificarMensaje(String mensaje) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(this.mensajeLbl));
        assertTrue("Mensaje erroneo", this.mensajeLbl.getText().contains(mensaje));
    }
}
