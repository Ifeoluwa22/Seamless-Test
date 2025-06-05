package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AssessmentTest {

    WebDriver driver = null;

    @BeforeClass
    public void launchChrome() {

        System.setProperty("webdriver.chrome.driver", "/Users/ifeoluwa/IdeaProjects/SeamlessHR/src/chromedriver");
        driver = new ChromeDriver(); //Launch browser
        driver.manage().window().maximize();//To Maximize the browser
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);  //Add implicit wait
        //launch URl
        driver.get("https://www.saucedemo.com/");
        System.out.println("Launch Webpage");

    }


    @Test(priority = 1) // Verify that user cannot proceed with an empty username field
    public void loginTestTwo() throws InterruptedException {
        aLogin login = new aLogin(driver);
        login.getUsername().sendKeys("");
        login.getPassword().sendKeys("secret_sauce");
        login.getLoginButton().click();

        Thread.sleep(5000);

        String errorMessage = login.displayError().getText();
        System.out.println("Actual Result: User is not allowed to login. " + errorMessage +" is displayed");
        driver.navigate().refresh();
        //login.getUsername().clear();
        //login.getPassword().clear();
        Thread.sleep(3000);
    }


    @Test(priority = 2) // Verify that user cannot proceed with an empty password field
    public void loginTestThree() throws InterruptedException {
        aLogin login = new aLogin(driver);

        login.getUsername().sendKeys("standard_user");
        login.getPassword().sendKeys("");
        login.getLoginButton().click();

        Thread.sleep(5000);

        String errorMessage = login.displayError().getText();
        System.out.println("Expected Result: User is not allowed to login. " + errorMessage +" is displayed");
        login.getUsername().clear();
        login.getPassword().clear();
        Thread.sleep(3000);
    }

    @Test(priority = 3) // Verify that user cannot proceed with an empty username and password field
    public void loginTestFour() throws InterruptedException {
        aLogin login = new aLogin(driver);
        login.getUsername().sendKeys("");
        login.getPassword().sendKeys("");
        login.getLoginButton().click();

        Thread.sleep(5000);
        String errorMessage = login.displayError().getText();
        System.out.println("Expected Result: User is not allowed to login. " + errorMessage +" is displayed");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 4) // Verify that user cannot proceed with an invalid password
    public void loginTestFive() throws InterruptedException {
        aLogin login = new aLogin(driver);
        login.getUsername().sendKeys("standard_user");
        login.getPassword().sendKeys("secretSSauce");
        login.getLoginButton().click();

        Thread.sleep(5000);
        String errorMessage = login.displayError().getText();
        System.out.println("Expected Result: User is not allowed to login. " + errorMessage +" is displayed");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 5) // Verify that if username is "locked_out" User should be unable to login and an error message is displayed
    public void loginTestSix() throws InterruptedException {
        aLogin login = new aLogin(driver);
        login.getUsername().sendKeys("locked_out_user");
        login.getPassword().sendKeys("secret_sauce");
        login.getLoginButton().click();

        Thread.sleep(5000);
        String errorMessage = login.displayError().getText();
        System.out.println("Expected Result: User is not allowed to login. " + errorMessage +" is displayed");
        login.getUsername().clear();
        login.getPassword().clear();
        Thread.sleep(3000);
    }

    @Test(priority = 6) // Verify that if username is invalid an error message is displayed
    public void loginTestSeven() throws InterruptedException {
            aLogin login = new aLogin(driver);
            login.getUsername().sendKeys("Problemuser");
            login.getPassword().sendKeys("secret_sauce");
            login.getLoginButton().click();

            Thread.sleep(5000);
            String errorMessage = login.displayError().getText();
            System.out.println("If user has an invalid username: Error message stating that " + errorMessage + " is returned." );
        driver.navigate().refresh();

        Thread.sleep(3000);
        }

    @Test(priority = 7) // Verify that user can login successfully
    public void loginTest() throws InterruptedException {
        aLogin login = new aLogin(driver);
        login.getUsername().sendKeys("standard_user");
        login.getPassword().sendKeys("secret_sauce");
        login.getLoginButton().click();

        Thread.sleep(7000);
        System.out.println("You have logged in successfully");

    }

    @Test(priority = 8)
    public void items() throws InterruptedException {
        bSelectItems items = new bSelectItems(driver);
        items.addBackPack().click();
        Thread.sleep(3000);
        items.addBikeLight().click();
        Thread.sleep(3000);
        items.addRedShirt().click();
        Thread.sleep(3000);
        items.clickCartIcon().click();
        Thread.sleep(3000);
        System.out.println("You have a backpack, bikelight and a red shirt in your cart");
        Thread.sleep(5000);
    }


    @Test(priority = 9)
    public void myCart() throws InterruptedException {
        cValidateCart myCart = new cValidateCart(driver);
        String firstCartText = myCart.addBikeLight().getText();
        String secondCartText = myCart.addBackPack().getText();
        String thirdCartText = myCart.addRedShirt().getText();
        SoftAssert confirm = new SoftAssert();
        confirm.assertEquals(firstCartText, "Sauce Labs Bike Light");
        confirm.assertEquals(secondCartText, "Sauce Labs Backpack");
        confirm.assertEquals(thirdCartText, "Test.allTheThings() T-Shirt (Red)");
        System.out.println(firstCartText + " " + secondCartText + " " + thirdCartText);
        myCart.clickCheckout().click();
        System.out.println("Successfully validated items");
        confirm.assertAll();

        Thread.sleep(5000);
    }


    @Test(priority = 10)
    public void checkoutForm() throws InterruptedException {
        dCheckout checkoutForm = new dCheckout(driver);
        checkoutForm.inputFirstName().sendKeys("Ifeoluwa");
        checkoutForm.inputLastName().sendKeys("Adeboye");
        checkoutForm.inputZipCode().sendKeys("100102");
        Thread.sleep(3000);
        checkoutForm.clickContinue().click();
        System.out.println("You successfully checked out some items");

        Thread.sleep(5000);

    }

    @Test(priority = 11)
    public void finalAssertion() throws InterruptedException {
        eConfirmOrder cartSummary = new eConfirmOrder(driver);
        String cartTextOne = cartSummary.bikeLightHeader().getText();
        String cartTextTwo = cartSummary.backPackHeader().getText();
        String cartTextThree = cartSummary.redShirtHeader().getText();
        SoftAssert confirmText = new SoftAssert();
        confirmText.assertEquals(cartTextOne, "Sauce Labs Bike Light");
        confirmText.assertEquals(cartTextTwo, "Sauce Labs Backpack");
        confirmText.assertEquals(cartTextThree, "Test.allTheThings() T-Shirt (Red)");
        System.out.println("The Cart Summary page is displayed");

        cartSummary.clickFinishButton().click();
        Thread.sleep(3000);
        String thanks = cartSummary.thanksText().getText();
        System.out.println("Final Thank you screen displayed");
        confirmText.assertEquals(thanks, "Thank you for your order!");
        confirmText.assertAll();
        Thread.sleep(5000);

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
 }