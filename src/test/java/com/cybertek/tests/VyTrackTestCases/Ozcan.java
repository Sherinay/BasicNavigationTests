package com.cybertek.tests.VyTrackTestCases;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ozcan
{ WebDriver driver;
Actions actions;
WebDriverWait wait;
    @Test
    public void TestCase4() throws InterruptedException {
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/user/login");
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
        WebElement username=driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("storemanager85");
        WebElement password=driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Actions action=new Actions(driver);
        Thread.sleep(5000);
        WebElement Activities=driver.findElement(By.linkText("Activities"));
        action.moveToElement(Activities).build().perform();
        WebElement Calendar=driver.findElement(By.xpath("//span[contains(text(),'Calendar Event')]"));
        action.moveToElement(Calendar).build().perform();
        Calendar.click();
        Thread.sleep(2000);
        Thread.sleep(3000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        String RowsNum = "Total Of " + rows.size() + " Records";
        System.out.println(RowsNum);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String RecordsNum = driver.findElement(By.xpath("//label[contains(text (), 'Total of')]")).getText();
        System.out.println(RecordsNum);
        Assert.assertEquals(RecordsNum, RowsNum);
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        WebElement dotView=driver.findElement(By.xpath("//tbody/tr[15]/td[9]//li[@class='launcher-item']"));



        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tbody/tr[15]/td[9]"))));
        actions.moveToElement(driver.findElement(By.xpath("//tbody/tr[15]/td[9]"))).perform();
        Thread.sleep(2000);
        List<WebElement> viEdDe=driver.findElements(By.xpath("//tbody/tr[15]/td[9]/div/div/ul/li/ul/li/a"));

        for (WebElement expand : viEdDe) {
            System.out.println(expand.getAttribute("title"));

        }

            }
        }

