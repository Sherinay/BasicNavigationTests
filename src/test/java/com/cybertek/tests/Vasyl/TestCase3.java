package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase3 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on
button one!”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Multiple Buttons")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\'content\']/div[1]/button[1]")).click();
        String displayRsl=driver.findElement(By.id("result")).getText();
        System.out.println(displayRsl);
        String expectedRsl="Clicked on button one!";

        System.out.println(StringUtility.verifyEquals(expectedRsl, displayRsl));
        driver.quit();


    }




}
