package com.cybertek.tests.navigationHomework;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {
    public static void main(String[] args) throws InterruptedException {
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "Selenium" );
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://google.com");


        for(String each: searchStrs){
            WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(2000);
        searchBox.sendKeys(new String[]{each});
        searchBox.submit();
        WebElement link=driver.findElement(By.className("TbwUpd"));
        link.click();
        String nav= driver.getCurrentUrl();

        boolean result= StringUtility.verifyEquals("https://www.java.com",nav);
        System.out.println(result);
        driver.navigate().back();
        driver.navigate().back();
        }

   //     driver.quit();

//        WebElement searchBox = driver.findElement(By.name("q"));
//        Thread.sleep(2000);
//        searchBox.sendKeys(new String[]{"Java"});
//        searchBox.submit();
//        WebElement link1=driver.findElement(By.className("TbwUpd"));
//        link1.click();
//        String nav1= driver.getCurrentUrl();
//        boolean result1= StringUtility.verifyEquals("https://www.java.com",nav1);
//        System.out.println(result1);
//
//        driver.navigate().back();
//        driver.navigate().back();
//        Thread.sleep(200);
//        WebElement searchBox2=driver.findElement(By.name("q"));
//        searchBox2.sendKeys(new String[]{"JUnit"});
//        searchBox2.submit();
//        WebElement link2=driver.findElement(By.className("LC20lb"));
//        link2.click();
//        String nav2=driver.getCurrentUrl();
//        boolean result2=StringUtility.verifyEquals("https://junit.org › junit5",nav2);
//        System.out.println(result2);
//
//        driver.navigate().back();
//        driver.navigate().back();
//        Thread.sleep(200);
//        WebElement searchBox3=driver.findElement(By.name("q"));
//        searchBox3.sendKeys(new String[]{"Selenium"});
//        searchBox3.submit();
//        WebElement link3=driver.findElement(By.className("LC20lb"));
//        link3.click();
//        String nav3=driver.getCurrentUrl();
//        boolean result3=StringUtility.verifyEquals("https://www.seleniumhq.org",nav3);
//        System.out.println(result3);
//
//        driver.navigate().back();
//        driver.navigate().back();
//
//        Thread.sleep(2000);
//        driver.quit();













    }
}
