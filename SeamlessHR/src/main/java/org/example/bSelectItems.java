package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bSelectItems {
    WebDriver Sdriver = null;

    public bSelectItems(WebDriver driver) {
        Sdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLight;

    public WebElement addBikeLight() {
        return bikeLight;
    }

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement backPack;

    public WebElement addBackPack() {
        return backPack;
    }

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement redShirt;

    public WebElement addRedShirt() {
        return redShirt;
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cart;

    public WebElement clickCartIcon() {
        return cart;
    }

    @FindBy(xpath = "(//button[normalize-space()='Checkout'])[1]")
    private WebElement checkout;

    public WebElement clickCheckout() {
        return checkout;
    }
}
