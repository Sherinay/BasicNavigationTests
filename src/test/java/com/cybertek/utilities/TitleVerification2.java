package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    /*
    Tests: Title and URLtest 2
    1.Create a new class TitleVerification2under utilities packageand create a main method.
    2.Add this ArrayList declaration to the main method:
    List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");
    3.Visit all websites one by one.
    4.Verify that URLof the website contains the title of the website.Ignore spacesand casein comparison.
    For example,title of in the first websitetitle is Lulu and Giorgiaand the URLis https://www.luluandgeorgia.com/.
    So,this test case must pass.5.Close the browser at theendof the test.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/", "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");
        for(String each: urls){
            Thread.sleep(1000);
            driver.get(each);
            String title=driver.getTitle().toLowerCase().replace(" ","").replace("-","").replace(".","");
            System.out.println(title);
            boolean result=driver.getCurrentUrl().contains(title);
            System.out.println(result);


        }

        driver.quit();

        driver.quit();








    }
}
