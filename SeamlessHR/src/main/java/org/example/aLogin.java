package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aLogin {
    WebDriver Sdriver = null;
    public aLogin(WebDriver driver) {
        Sdriver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#user-name")
    private WebElement username;
    public WebElement getUsername(){
        return username;
    }

    @FindBy(css = "#password")
    private WebElement password;
    public WebElement getPassword(){
        return password;
    }

    @FindBy (css = "#login-button")
    private WebElement loginButton;
    public WebElement getLoginButton(){
        return loginButton;
    }

    @FindBy (css = "h3[data-test='error']")
    private WebElement errorMessage;
    public WebElement displayError() {
        return errorMessage;
    }
}
