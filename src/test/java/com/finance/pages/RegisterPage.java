package com.finance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy(name="first_name")
    WebElement firsNamTxt;

    @FindBy(name="last_name")
    WebElement lastNameTxt;

    @FindBy(name="username")
    WebElement userNameTxt;

    @FindBy(name="email")
    WebElement emailTxt;

    @FindBy(name="password")
    WebElement passwordTxt;

    @FindBy(name="repeat_password")
    WebElement repeatPasswordTxt;

    @FindBy(name="phone")
    WebElement phoneNumberTxt;

    @FindBy(name="birthdate")
    WebElement dateTxt;

    @FindBy(name="cc")
    WebElement crediCardTxt;

    @FindBy(name="expiration")
    WebElement expirationTxt;

    @FindBy(name="cvv")
    WebElement cvvTxt;

    @FindBy(css=".btn")
    WebElement registerButton;
}
