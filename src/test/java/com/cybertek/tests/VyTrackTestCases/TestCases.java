package com.cybertek.tests.VyTrackTestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.tests.Automate2016Olympics.pages.BasePage;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {
    //creating instance variable from reference from the Webdriver Interface
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;
    JavascriptExecutor js;

    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Regression tests");

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }


    //setting up driver for the coming test cases
    @BeforeMethod
    public void setUpDriver() throws InterruptedException {
        //set up driver, actions and wait
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 30);

        //login with credentials
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("storemanager85");
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();

        //mouse hove over Activities module
        WebElement activities = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[5]"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        actions.moveToElement(activities).perform();

        js = (JavascriptExecutor) driver;

        //click on calender events
        WebElement cldevent = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]")));
        cldevent.click();
    }

    //    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Verify Option button")             //Passed
    public void test1() {
        extentLogger = report.createTest("Verify Option Button");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        extentLogger.info("Wait until the presence of the element -- options");
        WebElement options = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='btn btn-link dropdown-toggle']")));
        extentLogger.info("get option text");
        System.out.println(options.getText());
        extentLogger.info("Compare the expected to actual");
        Assert.assertEquals(options.getText(), "Options");

    }

    @Test(description = "Verify page number equals to 1")   //Passed
    public void test2() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement number = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='icons-holder']//input")));
        System.out.println(number.getAttribute("value"));
        Assert.assertEquals(number.getAttribute("value"), "1");
    }

    @Test(description = "Verify view per page number equals to 25")
    public void test3() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement option = driver.findElement(By.xpath("//a[@data-size='25']"));
        String is25 = option.getAttribute("data-size");
        Assert.assertEquals(is25, "25");
    }                               //Passed

    @Test(description = "Verify total of 20 records")       //Passed
    public void test5() throws InterruptedException {
//    List<WebElement> calenderRow=driver.findElements(By.xpath("//tbody/tr"));
//        System.out.println(calenderRow.size());
//        int size=0;
//
//    for (WebElement eachRow : calenderRow) {
//        size++;
//
//    }
//        System.out.println("Element size is "+size);
//
//        List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));
//        int size = 0;
//        for (WebElement each : list) {
//            System.out.println(size);
//            System.out.println(each.getText());
//            size++;
//        }
//        System.out.println("List element size is " + size);
//        String record =""+size;
//        String recordd= driver.findElement(By.xpath("//label[3]")).getText();
//        Assert.assertTrue(recordd.contains(record));
        //explicit wait or thread sleep
        Thread.sleep(3000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        String RowsNum = "Total Of " + rows.size() + " Records";
        System.out.println(RowsNum);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String RecordsNum = driver.findElement(By.xpath("//label[contains(text (), 'Total of')]")).getText();
        System.out.println(RecordsNum);
        Assert.assertEquals(RecordsNum, RowsNum);
    }

    @Test(description = "checkbox select all")              //Passed
    public void test6() throws InterruptedException {
        Thread.sleep(3000);
        WebElement angel = driver.findElement(By.xpath("//i[@class='caret']"));
        wait.until(ExpectedConditions.visibilityOf(angel));
        angel.click();
        WebElement selectAll = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu__select-all-header-cell detach dropdown-menu__floating']/li[1]/a"));
        selectAll.click();
        Assert.assertTrue(driver.findElement(By.xpath("//thead//input")).isSelected());

    }

    @Test(description = " select Testers meeting")                  //Passed        need verification
    public void test7() throws InterruptedException {
        Thread.sleep(3000);
        WebElement testerMeeting = driver.findElement(By.xpath("//tbody/tr[15]/td[2]"));
        testerMeeting.click();
    }

    @Test(description = "Three dots for Testers Meeting")           //Didn't Passed . Loop Testers Meeting
    public void test8() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.moveToElement(driver.findElement(By.xpath("//tbody/tr[15]/td[9]"))).perform();
        Thread.sleep(2000);
        List<WebElement> viEdDe = driver.findElements(By.xpath("//tbody/tr[15]/td[9]//ul//a"));
        Thread.sleep(3000);
        for (WebElement expand : viEdDe) {
            System.out.println(expand.getAttribute("title"));
            Thread.sleep(3000);
            Assert.assertTrue(expand.isDisplayed());
        }


    }

    @Test(description = "Grid Options”")                        //Didn't Pass   unable to locate checkbox for Assertion
    public void test9() throws InterruptedException {
        extentLogger = report.createTest("Grid Options");
        Thread.sleep(3000);
        extentLogger.info("find the grid drop down Webelement");
        WebElement grid = driver.findElement(By.xpath("//*[@class='column-manager dropdown']"));
        wait.until(ExpectedConditions.visibilityOf(grid));
        extentLogger.info("click on the grid option");
        grid.click();
//        List<WebElement> listCheckbox = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr/td[3]/input"));
        extentLogger.info("All the clickable column text");
        List<WebElement> listTitle = driver.findElements(By.xpath("//tbody[@class='ui-sortable']//td[@class='title-cell']"));
        Thread.sleep(3000);
        extentLogger.info("Iterate through all the column and unclick all the option except for Title");
        for (WebElement eachTitle : listTitle) {
            if (eachTitle.getText().contains("Title")) {
                continue;
            }
            extentLogger.info("Unclick each of the option");
            eachTitle.click();
        }
        Thread.sleep(2000);
        extentLogger.info("Title option from the list");
        WebElement titelCheckbox = driver.findElement(By.xpath("//input[@id='column-c317']"));
        extentLogger.pass("Title is still displayes. Passed");
        Assert.assertTrue(titelCheckbox.isSelected());
    }


    @Test(description = "Create Calendar Event")                    //Passed
    public void test10() throws InterruptedException {
        extentLogger = report.createTest("Create Calendar Event");
        Thread.sleep(5000);
        WebElement createEvent = driver.findElement(By.xpath("//div[@class='row']//div[@class='btn-group']"));
        wait.until(ExpectedConditions.visibilityOf(createEvent));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        extentLogger.info("Click on Create Calendar Event");
        Thread.sleep(5000);
        createEvent.click();

        WebElement saveNClose = driver.findElement(By.xpath("//div[@class='pull-right']//a[@data-toggle='dropdown']"));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        extentLogger.info("Expand Save and close Menu");
        Thread.sleep(5000);
        saveNClose.click();

        List<WebElement> subList = driver.findElements(By.xpath("//div[@class='btn-group pull-right open']//ul[@class='dropdown-menu']//button"));
        for (WebElement eachList : subList) {
            System.out.println(eachList.getText());
            extentLogger.pass("Passed");
            Assert.assertTrue(eachList.isDisplayed());
        }


    }

    @Test(description = "Click Cancel and All Calendar Events page subtitle is displayed")  //Passed
    public void test11() throws InterruptedException {

        extentLogger = report.createTest("Create Calendar Event");

        WebElement createEvent = driver.findElement(By.xpath("//div[@class='row']//div[@class='btn-group']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='loader-mask shown'])")));
//        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        extentLogger.info("Click on Create Calendar Event");
//        boolean loadMask=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));
//        if(loadMask){
            Thread.sleep(5000);
            createEvent.click();
//        }


        extentLogger.info("Locate Cancel button");
        WebElement cancelButton = driver.findElement(By.xpath("//div[@class='pull-right']/div/div[2]"));
        Thread.sleep(5000);

//        boolean loadMask=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));
//        if(loadMask){
//            WebElement cancelButton=driver.findElement(By.xpath("//div[@class='pull-right']/div/div[2]"));
//            extentLogger.info("Clicn on the Cancel Button");
            cancelButton.click();
//        }

//        js.executeScript("arguments[0].click;",cancelButton);
        WebElement subtitle=driver.findElement(By.xpath("//div[@id='container']//h1"));
        Assert.assertTrue(subtitle.isDisplayed());

    }

    @Test(description = "difference between end and start time is exactly 1 hour")
    public void test12() throws InterruptedException {
        Thread.sleep(3000);
        WebElement createEvent = driver.findElement(By.xpath("//*[contains(text(),'Create Calendar event')])[3]"));
        createEvent.click();
        Thread.sleep(5000);
            WebElement startTime = driver.findElement(By.className("//*[@class='input-small timepicker-input start ui-timepicker-input']"));
            WebElement endTime = driver.findElement(By.className("//*[@class='input-small timepicker-input end ui-timepicker-input']"));
            System.out.println(startTime.getText().split(""));
            System.out.println(endTime.getText().split(""));


    }

    @Test(description = "end time is equals to 10:00 pm")
    public void test13() {

    }

    @Test(description = "start and end date input boxes are displayed")
    public void test14() {

    }

    @Test(description = "Verify that “Daily” is selected by default and following options are available in Repeats drop-down")
    public void test15() {

    }

    @Test(description = "Summary: Daily every 1 day")
    public void test16() {

    }

    @Test(description = "Summary: Daily every 1 day, end after 10 occurrences")
    public void test17() {

    }

    @Test(description = "Summary: Daily every 1 day, end by Nov 18, 2021")
    public void test18() {

    }

    @Test(description = "Summary: Weekly every 1 week on Monday, Friday")
    public void test19() {

    }

}
