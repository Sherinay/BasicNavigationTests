package com.cybertek.tests.navigationHomework;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTestsME {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver("microsoftedge");
        driver.get("https://google.com");
        String title1= driver.getTitle();
        Thread.sleep(1000);
        driver.navigate().to("https://etsy.com");
        String title2= driver.getTitle();
        Thread.sleep(1000);
        driver.navigate().back();
        String title3 = driver.getTitle();

        boolean return1= StringUtility.verifyEquals(title1,title3);
        System.out.println(return1);
        Thread.sleep(1000);
        driver.navigate().forward();

        String title4=driver.getTitle();
        boolean return2=StringUtility.verifyEquals(title2,title4);
        System.out.println(return2);
        Thread.sleep(1000);

        driver.quit();

    }
}
