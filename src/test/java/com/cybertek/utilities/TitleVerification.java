package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
/*
Tests: Title and URLtest1.
Create a new class TitleVerification under utilitiespackageand create a main method.
2.Add this ArrayList declaration to the main method:
List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
 "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
 3.Open chrome browser
 4.Visit all the websitesfrom step 3and verify that they all have the same title.
 5.Verify that all URLsof all pages start with http://practice.cybertekschool.com.
 6.Close the browser at the end of the test.
 */
public class TitleVerification {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                            "http://practice.cybertekschool.com/dropdown",
                                                "http://practice.cybertekschool.com/login");

        WebDriver driver=BrowserFactory.getDriver("chrome");

        for(String each: urls){
            Thread.sleep(1000);
            driver.get(each);
            boolean titleResult=driver.getTitle().equalsIgnoreCase("practice");
            System.out.println(titleResult);
        }

        String url="";
        for(String each: urls){
            Thread.sleep(1000);
            driver.get(each);
            url+=each;
            boolean urlResult=driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com");
            System.out.println(urlResult);
        }




        driver.quit();




    }
}
