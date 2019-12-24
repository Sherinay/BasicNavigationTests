package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    /*
            Test case #1
        Step 1. Go to https://practice-cybertekschool.herokuapp.com
        Step 2. Click on “Sign Up For Mailing List”
        Step 3. Enter any valid name
        Step 4. Enter any valid email
        Step 5. Click on “Sign Up” button
        Expected result: Following message should be
        displayed: “Thank you for signing up. Click the
        button below to return to the home page.” Home
        button should be displayed.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement SignUpLink=driver.findElement(By.linkText("Sign Up For Mailing List"));
        Thread.sleep(500);
        SignUpLink.click();
        WebElement FullNameBox=driver.findElement(By.name("full_name"));
        FullNameBox.sendKeys("Sherinay Abdukerim");
        WebElement EmailBox=driver.findElement(By.name("email"));
        EmailBox.sendKeys("xierin_liebe@hotmail.com");
        WebElement SignUpBtn=driver.findElement(By.name("wooden_spoon"));
        SignUpBtn.click();

        String DisplayMsg=driver.findElement(By.name("signup_message")).getText();
        System.out.println(DisplayMsg);
        String ExpectedDisplayMsg="Thank you for signing up. Click the button below to return to the home page.";
        System.out.println(StringUtility.verifyEquals(DisplayMsg, ExpectedDisplayMsg));

        WebElement HomeBtn=driver.findElement(By.id("wooden_spoon"));
        System.out.println(HomeBtn.isDisplayed());

    }



}
