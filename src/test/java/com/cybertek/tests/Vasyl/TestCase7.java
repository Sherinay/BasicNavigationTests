package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase7 {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed:
“email address is not a valid
Email format is not correct”
     */
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[4]/div/input")).sendKeys("testers@email");
        System.out.println(driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[4]/div/small[2]")).getText() + "\n"+driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[4]/div/small[3]")).getText());
        driver.quit();

    }
}
