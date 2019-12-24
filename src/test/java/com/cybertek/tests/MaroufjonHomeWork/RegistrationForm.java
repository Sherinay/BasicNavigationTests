package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    public WebDriver driver;

    @BeforeMethod
    public void driverSetup(){
    driver=BrowserFactory.getDriver("firefox");
    driver.manage().window().maximize();
    driver.get("https://practice-cybertekschool.herokuapp.com/");
    driver.findElement(By.linkText("Registration Form")).click();

}
    @AfterMethod
    public void driverClose() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//input[@class='form-control' and @name='birthday']")).sendKeys("wrong_dob");
        String warning=driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).getText();
        Assert.assertEquals(warning,"The date of birth is not valid");
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(1000);
        String CLang=driver.findElement(By.xpath("//div[contains(@class,'col-sm-5')]//div[contains(@class,'form-check form-check-inline')][1]")).getText();
        String java=driver.findElement(By.xpath("//div[contains(@class,'col-sm-5')]//div[contains(@class,'form-check form-check-inline')][2]")).getText();
        String JavaScript=driver.findElement(By.xpath("//div[contains(@class,'col-sm-5')]//div[contains(@class,'form-check form-check-inline')][3]")).getText();
        Assert.assertEquals(CLang,"C++");
        Assert.assertEquals(java,"J     ava");
        Assert.assertEquals(JavaScript,"JavaScript");
    }

    @Test
    public void test3(){
        driver.findElement(By.xpath("//input[@class='form-control' and @name='firstname']")).sendKeys("S");
        String warning=driver.findElement(By.xpath("//div[contains(@class,'form-group has-feedback has-error')]//small[2]")).getAttribute("innerHTML");
        Assert.assertEquals(warning,"first name must be more than 2 and less than 64 characters long");
    }

    @Test
    public void test4(){
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("A");
        String warning=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).getText();
        Assert.assertEquals(warning,"The last name must be more than 2 and less than 64 characters long");
    }

    @Test
    public void test5() throws InterruptedException {
        driver.findElement(By.xpath("//input[@class='form-control' and @name='firstname']")).sendKeys("Sherinay");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Abdukerim");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Shirin");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xierin_liebe@hotmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("301-000-1122");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/02/1990");
        Thread.sleep(500);
        //locate the element with select tag
        WebElement element=driver.findElement(By.xpath("//select[@name='department']"));
        // Create Select object by passing the element from step 2 as constructor
        Select dptlist=new Select(element);
        dptlist.selectByVisibleText("Tourism Office");

        WebElement title=driver.findElement(By.xpath("//select[@name='job_title']"));
        Select jobtitle= new Select(title);
        jobtitle.selectByVisibleText("Developer");

        WebElement chekbx=driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        chekbx.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();

        String succsmsg="You've successfully completed registration!";
        String dsplmsg=driver.findElement(By.xpath("//div[@id='content']//p")).getText();
        System.out.println(dsplmsg);
        Assert.assertEquals(dsplmsg,succsmsg);

    }




}
