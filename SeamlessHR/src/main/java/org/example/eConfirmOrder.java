package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eConfirmOrder {
    WebDriver Sdriver = null;
    public eConfirmOrder(WebDriver driver) {
        Sdriver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//div[normalize-space()='Sauce Labs Bike Light'])[1]")
    private WebElement bikeLight;
    public WebElement bikeLightHeader(){
        return bikeLight;
    }

    @FindBy(xpath = "(//div[normalize-space()='Sauce Labs Backpack'])[1]")
    private WebElement backPack;
    public WebElement backPackHeader(){
        return backPack;
    }

    @FindBy(xpath = "(//div[normalize-space()='Test.allTheThings() T-Shirt (Red)'])[1]")
    private WebElement redShirt;
    public WebElement redShirtHeader(){
        return redShirt;
    }

    @FindBy(css = "#finish")
    private WebElement finishButton;
    public WebElement clickFinishButton(){
        return finishButton;
    }

    @FindBy(xpath = "(//h2[normalize-space()='Thank you for your order!'])[1]")
    private WebElement Thanks;
    public WebElement thanksText(){
        return Thanks;
    }



}
