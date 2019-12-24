package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1.Create a new class TitleVerification3under utilities package and create a main method.
        2.Do the same test case as in the previousexercise, except this time open and close a new browser for each web site.
         */


        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/", "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");
    /*    for(String each: urls){
            urls(driver,each);
         //   driver.switchTo().window(tabs.get(1));
        }
        driver.quit();
     }
    public static void urls(WebDriver driver, String each){
        driver.get(each);
        String title=driver.getTitle().replace(" ","");
        String currentURL=driver.getCurrentUrl();
        boolean resutl=currentURL.contains(title);
        System.out.println(resutl);
*/
    for(String each: urls){
        driver.get(each);
        String title=driver.getTitle().toLowerCase().replace(" ","");
        String url=driver.getCurrentUrl();
        if(url.contains(title)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();
    }
    }
}
