package com.cybertek.tests.navigationHomework;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VytrackShortcutFunctionality {
    /*
    1. Open browser
2. Go to Vytrack login page
3. Login as a sales manager
4. Verify Dashboard page is open
5. Click on Shortcuts icon
6. Click on link See full list
7. Click on link Opportunities
8. Verify Open opportunities page is open
9. Click on Shortcuts icon
10. Click on link See full list
11. Click on link Vehicle Service Logs
12. Verify error message text is You do not have permission to perform this action.
13. Verify Shortcut Actions List page is still open
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        String dashboard=driver.findElement(By.className("oro-subtitle")).getText();
        if(dashboard.equalsIgnoreCase("dashboard")){
            System.out.println("PASS");
        }
        Thread.sleep(1000);
        driver.findElement(By.className("fa-share-square")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        Thread.sleep(500);
        String errorMsg=driver.findElement(By.className("message")).getText();
        System.out.println(errorMsg);
        String title=driver.getTitle();
        System.out.println(title);
        driver.quit();


    }
}
