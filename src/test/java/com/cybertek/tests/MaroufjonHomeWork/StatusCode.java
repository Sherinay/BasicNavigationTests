package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class StatusCode {
    WebDriver driver;
    @BeforeMethod
    public void driverSetUp(){
        driver= BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }
//    @DataProvider (name="DisplayedMessage")
//    public  Object[][] displayedMsg(String msg, String message){
//        Object[][] msg=new Object[4][4];
//        msg [0][0]="This page returned a 200 status code";
//        msg [0][1]="This page returned a 301 status code";
//        msg [0][2]="This page returned a 404 status code";
//        msg [0][3]="This page returned a 500 status code";
//
//        msg [1][0]="This page returned a 200 status code";
//        msg [1][1]="This page returned a 301 status code";
//        msg [1][2]="This page returned a 404 status code";
//        msg [1][3]="This page returned a 500 status code";
//
//        msg [2][0]="This page returned a 200 status code";
//        msg [2][1]="This page returned a 301 status code";
//        msg [2][2]="This page returned a 404 status code";
//        msg [2][3]="This page returned a 500 status code";
//
//        msg [3][0]="This page returned a 200 status code";
//        msg [3][1]="This page returned a 301 status code";
//        msg [3][2]="This page returned a 404 status code";
//        msg [3][3]="This page returned a 500 status code";
//        return msg;
//    }

//    @Test(dataProvider = "DisplayedMessage")
//    public void test(String message){
//
//        }
//
//
//    }

//    @AfterMethod
//    public void teardownMethod() throws InterruptedException {
//        Thread.sleep(500);
//        driver.quit();
//    }
}
