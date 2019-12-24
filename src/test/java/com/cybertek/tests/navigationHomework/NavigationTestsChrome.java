package com.cybertek.tests.navigationHomework;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTestsChrome {
    /*
1.Open browser
2.Go to website https://google.com
3.Save the title in a string variable
4.Go to https://etsy.com
5.Save the title in a string variable
6.Navigate back to previous page
7.Verify that title is same is in step 3
8.Navigate forward to previous page
9.Verify that title is same is in step 5
10.Each test should close the browser after completion
GitHub1.Pushthis project toGitHub. Do not push the target folderto GitHub.
Push other filesandfolders.Ignore thetargetfolder.
 */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://google.com");
        String title1= driver.getTitle();
        Thread.sleep(1000);
        driver.navigate().to("https://etsy.com");
        String title2= driver.getTitle();
        Thread.sleep(1000);
        driver.navigate().back();
        String title3 = driver.getTitle();

        boolean return1=StringUtility.verifyEquals(title1,title3);
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