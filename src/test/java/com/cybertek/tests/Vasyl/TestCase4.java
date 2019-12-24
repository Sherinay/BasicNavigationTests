package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase4 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into first name input box.
Step 4. Verify that warning message is displayed:
“first name can only consist of alphabetical letters”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        Thread.sleep(500);
        driver.findElement(By.className("form-control")).sendKeys("123");
        String warningMSG=driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[1]/div/small[3]")).getText();
        System.out.println(warningMSG);
        Thread.sleep(500);
        driver.quit();



    }
}
