package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cValidateCart {
    WebDriver Sdriver = null;

    public cValidateCart(WebDriver driver) {
        Sdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id='item_0_title_link'] div[class='inventory_item_name']")
    private WebElement bikeLight;

    public WebElement addBikeLight() {
        return bikeLight;
    }

    @FindBy(css = "a[id='item_4_title_link'] div[class='inventory_item_name']")
    private WebElement backPack;

    public WebElement addBackPack() {
        return backPack;
    }

    @FindBy(css = "a[id='item_3_title_link'] div[class='inventory_item_name']")
    private WebElement redShirt;

    public WebElement addRedShirt() {
        return redShirt;
    }


    @FindBy(xpath = "(//button[normalize-space()='Checkout'])[1]")
    private WebElement checkout;

    public WebElement clickCheckout() {
        return checkout;
    }
}
