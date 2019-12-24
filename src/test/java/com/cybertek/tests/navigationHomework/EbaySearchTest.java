package com.cybertek.tests.navigationHomework;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchTest {
    /*
    1. Open browser
2. Go to https://ebay.com
3. Search for wooden spoon
4. Save the total number of results
5. Click on link All
6. Verify that number of results is bigger than the number in step 4
7. Navigate back to previous research results page
8. Verify that wooden spoon is displayed in the search box
9. Navigate back to home page
10. Verify that search box is blank
     */
    //Xpath=//tagname[@attribute='value']

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        driver.manage().window().maximize();
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys(new String[]{"wooden spoon"});
        searchBox.submit();
        String totalNum=driver.findElement(By.className("srp-controls__count-heading"))
                            .getText().split(" ")[0].replace(",","");


        System.out.println(totalNum);
        WebElement All=driver.findElement(By.xpath("//*[@id=\'x-refine__group__0\']/ul/li/a"));

        All.click();

        Thread.sleep(500);
        String AllNumber=driver.findElement(By.className("srp-controls__count-heading"))
                            .getText().split(" ")[0].replace(",","");


        System.out.println(AllNumber);

        int totalInt = (Integer.parseInt(totalNum));
        int totalAll = (Integer.parseInt(AllNumber));

        if(totalInt<totalAll){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(500);
        driver.navigate().back();
        WebElement searchBox2=driver.findElement(By.id("gh-ac"));
        String textInside=searchBox2.getAttribute("value");
        if(textInside.contains("wooden spoon")){
            System.out.println(textInside+" is displayed");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(100);
        driver.navigate().back();
        if(!textInside.isEmpty()){
            System.out.println("NOT EMPTY");
        }else{
            System.out.println("EMPTY");
        }
        driver.quit();













    }
}
