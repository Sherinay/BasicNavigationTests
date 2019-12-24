package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpForMailingList {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(500);
        WebElement copy= driver.findElement(By.xpath("//a[@href='#copy' and @title='Copy email address to clipboard']"));
                   copy.click();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("John Smith");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
//        String email=copy.getAttribute("value").toString();
//        System.out.println(email);
//
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@class='radius' and @name='wooden_spoon']")).click();
        String exptmsg="Thank you for signing up. Click the button below to return to the home page.";
        String msg= driver.findElement(By.xpath("//h3[@class='subheader' and @name='signup_message']")).getText();
        System.out.println(msg);
        Assert.assertEquals(msg,exptmsg);
        Thread.sleep(2000);
        driver.navigate().to("https://www.tempmailaddress.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='table table-hover']//tbody//tr[1]//span[@class='glyphicon glyphicon-envelope']")).click();
        String emFrom=driver.findElement(By.xpath("//span[@id='odesilatel']")).getText();
        System.out.println(emFrom);
        Assert.assertEquals(emFrom,"do-not-reply@practice.cybertekschool.com");
        String emBody=driver.findElement(By.xpath("//span[@id='predmet']")).getText();
        System.out.println(emBody);
        Assert.assertEquals(emBody,"Thanks for subscribing to practice.cybertekschool.com!");
        driver.quit();


    }



}
