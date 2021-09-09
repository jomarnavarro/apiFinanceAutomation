package com.finance.pages;

import com.finance.pojo.frontEnd.StockInformation;
import com.finance.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class PortfolioPage extends BasePage {

    public PortfolioPage(WebDriver driver) {
        super(driver);
    }

    public void verificarMensajeBienvenida(String mensaje) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(this.mensajeLbl));
        assertTrue("Mensaje erroneo", this.mensajeLbl.getText().contains(mensaje));
    }



    public void verificarTablaTransacciones(String concepto) throws Exception {
        if(concepto.toLowerCase().equalsIgnoreCase(Constants.CASH_CONCEPT)) {
            WebElement cashRow = driver.findElement(By.cssSelector("[val-type='cash']"));
            assertTrue(concepto + " is not included in transactions.", cashRow.getText().contains(concepto));
        } else {
            String xpath = "//tr[@val-type='stock']/td[@col-type='symbol' and .= 'SYMBOL']"
                    .replace("SYMBOL", concepto);
            WebElement stockColumnElem;
            try {
                stockColumnElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                assertTrue("Element for " + concepto + " is not visible.", stockColumnElem.isDisplayed());
            }catch(Exception e) {
                System.out.println(concepto + " is not present in transaction table.");
                throw new Exception("Element for " + concepto + " is not visible");
            }
        }
    }

    public void verificarMsjCompraExitosa(String mensaje) {
        wait.until(ExpectedConditions.visibilityOf(this.mensajeLbl));
        assertTrue("Mensaje no desplegado correctamente: ", this.mensajeLbl.getText().contains(mensaje));
    }

    public void verificarNumAcciones(String symbol, int numAcciones) throws Exception {
        String xpath = "//tr[@val-type='stock' and contains(., 'SYMBOL')]/td[@col_type='num_shares']"
                .replace("SYMBOL", symbol);
        try {
            WebElement numAccionesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            assertTrue("Numero de acciones incorrecto", Integer.parseInt(numAccionesElement.getText()) > numAcciones);
        } catch(Exception e) {
            throw new Exception("Symbol does not exist");
        }
    }

    public StockInformation getStockInformation(String symbol) {
        try {
            //si existe actualmente la accion en el portafolio
            String xpath = "//tr[@val-type='stock' and contains(., 'SYMBOL')]"
                    .replace("SYMBOL", symbol);

            WebElement nameElem = driver.findElement(By.xpath(xpath + "/td[@col-type='company_name']"));
            WebElement numSharesElem = driver.findElement(By.xpath(xpath + "/td[@col_type='num_shares']"));
            WebElement priceElem = driver.findElement(By.xpath(xpath + "/td[@col-type='curr_val_per_share']"));
            WebElement totalElem = driver.findElement(By.xpath(xpath + "/td[@col-type='curr_val_shares']"));

            String companyName = nameElem.getText();
            int numShares = Integer.parseInt(numSharesElem.getText());
            double price = Double.parseDouble(priceElem.getText());
            double total = Double.parseDouble(totalElem.getText());

            return new StockInformation(symbol, companyName, numShares, price, total);
        }catch(Exception e) {
            return new StockInformation(symbol, "", 0, 0, 0);
        }



    }
}
