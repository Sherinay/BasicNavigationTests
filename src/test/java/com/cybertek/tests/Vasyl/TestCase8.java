package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase8 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “5711234354” into phone number
input box.
Step 4. Verify that warning message is displayed:
“Phone format is not correct”
     */
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[6]/div/input")).sendKeys("5711234354");
        System.out.println(driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[6]/div/small[2]")).getText());
        driver.quit();

    }
}
