package com.cybertek.tests.Vasyl;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase2 {
    /*
            Step 1. Go to https://practice-cybertekschool.herokuapp.com
        Step 2. Verify that number of listed examples is
        equals to 48.
        Hint: use findElemnts() and size()
        methods.
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        int totalNum=driver.findElements(By.className("list-group-item")).size();

        int expectdNum=48;
        System.out.println(totalNum);
        if(totalNum==expectdNum){
            System.out.println(true);
        }else{
            System.out.println(false);
        }










      driver.close();

    }
}
