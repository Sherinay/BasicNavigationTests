package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase5 {
    /*
    Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box.
Step 4. Verify that warning message is displayed:
“The last name can only consist of alphabetical
letters and dash”

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[2]/div/input")).sendKeys("123");
        String warningMSG=driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[2]/div/small[3]")).getText();
        System.out.println(warningMSG);
        Thread.sleep(500);
        driver.quit();






    }
}
