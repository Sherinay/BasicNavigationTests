package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {
    @Test
    public void test(){
        WebDriver driver= BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement uploadbtn= driver.findElement(By.xpath("//input[@id='file-upload']"));
        uploadbtn.sendKeys("C:\\Users\\xieri\\OneDrive\\Desktop\\practice.txt");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        String msg=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/h3")).getText();
        Assert.assertEquals(msg,"File Uploaded!");
        System.out.println(driver.findElement(By.id("uploaded-files")).getText());
        driver.quit();

    }

}
