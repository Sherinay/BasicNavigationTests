package com.cybertek.tests.navigationHomework;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTitleTest {
    /*
    Open browser
2. Go to Vytrack login page
3. Login as any user
4. Click on your name on top right
5. Click on My Configuration
6. Verify that title start with the same name on top right
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userBox=driver.findElement(By.id("prependedInput"));
        userBox.sendKeys("User1");
        WebElement passBox=driver.findElement(By.id("prependedInput2"));
        passBox.sendKeys("UserUser123");
        WebElement login=driver.findElement(By.id("_submit"));
        login.click();
        Thread.sleep(300);
        WebElement userNameDropDown=driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a"));
        userNameDropDown.click();
//        Select menu=new Select(userNameDropDown);
//        Thread.sleep(300);
//        menu.deselectByVisibleText("My Configuration");
//        Thread.sleep(300);
//        System.out.println(userNameDropDown.getText());
        WebElement menu=driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[2]/a"));
        menu.click();

        Thread.sleep(500);
        String title=driver.getTitle();
        System.out.println(title);

        String displayName=driver.findElement(By.id("user-menu")).getText();
        System.out.println(displayName);
        Thread.sleep(600);

        if(title.contains(displayName)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();






        }



















    }



