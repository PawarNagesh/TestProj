package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DevAgent {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\InCashMe-16\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dev.agent.incashme.com/ua/login");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }

    //Privacy policy and Terms&Condition
    @Test(enabled = false,priority = 0)
    public void TermsCondition () throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Terms & Condition')]")).click();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(1));
        driver.close();
        driver.switchTo().window(tabs3.get(0));
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
        //Thread.sleep(5000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        //Thread.sleep(7000);
    }
    //Forgot Password
    @Test(enabled = false,priority = 1)
    public void Forgotpassword () throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[not(@hidden) and @class='login-form']//input[@formcontrolname='email']")).sendKeys("testagent016@mailinator.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //div[@class='login-button not-allowd text-right mb10 enbl-lgn']//button[@class='btn lgn-btn'][contains(text(),'Submit')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //div[@class='login-button not-allowd text-right mb10 enbl-lgn']//a[contains(text(),'Back to Login')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //button[@class='swal2-confirm btn btn-success']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='form-group bmd-form-group']//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("91752");
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //div[@class='login-button not-allowd text-right mb10 mt40 enbl-lgn']//button[@class='btn lgn-btn'][contains(text(),'Submit')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //button[@class='swal2-confirm btn btn-success']")).click();
        Thread.sleep(10000);

    }
    //Login
    @Test(enabled = true ,priority = 2)
    public void Login() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"email\"]:nth-child(3)"))).sendKeys("testagent8@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwd"))).sendKeys("Nagesh@2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']"))).click();

    }
    //Homedashboard
    @Test(enabled = true ,priority = 3)
    public void Homedashboard() throws InterruptedException {
     //Using Mobile Number
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payeeName"))).sendKeys("9494028007");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='green-txt mb5']"))).click();  //Merchant
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blue-txt mb5']"))).click();   //Consumer
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).clear();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("201");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-red']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green']"))).click();
     //Create consumer
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn ftr-btn blue-btn w-100']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("Test con");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys("Test Five");
        driver.findElement(By.xpath("//button[@class='btnpicker btnpickerenabled']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='headerlabelbtn yearlabel']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='yearchangebtn mydpicon icon-mydpup yearchangebtnenabled']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),'1983')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='headerlabelbtn monthlabel']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),'Jun')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tr[2]//td[4]//div[1]//span[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys("testc06@mailinator.com");
        Thread.sleep(5000);
        driver.findElement(By.id("phone")).sendKeys("1234561234");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@id='profile_pic_select']")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//div[@class='move']")).isDisplayed();
        Thread.sleep(3000);
        //Cancel button-Profile
        //driver.findElement(By.xpath("//button[@class='btn btn-pink']")).click();
        Thread.sleep(3000);
        //Confirm button-Profile
        driver.findElement(By.xpath("//button[@id='send-mny']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='fileType']")).click();
        Thread.sleep(2000);
        // Passport->
        driver.findElement(By.xpath("//option[contains(text(),'Passport')]")).click();
        Thread.sleep(2000);
        // Driving License
        driver.findElement(By.xpath("//option[contains(text(),'Driving License')]")).click();
        Thread.sleep(2000);
        //Voter Id
        driver.findElement(By.xpath("//option[contains(text(),'Voter's Identity Card')]")).click();
        Thread.sleep(2000);
		//Aadhar-Card
		driver.findElement(By.xpath("//option[contains(text(),'Aadhar Card')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='aadhaar_front_select']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[@id='aadhaar_back_select']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-dirty ng-touched ng-valid']//button[@class='btn btn-blue float-right fs-16 ml10 mb30'][contains(text(),'Next')]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[text()='Previous']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-dirty ng-touched ng-valid']//button[@class='btn btn-blue float-right fs-16 ml10 mb30'][contains(text(),'Next')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='otp_val']")).sendKeys("91752");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-untouched ng-pristine ng-valid']//button[@class='btn btn-blue float-right fs-16 ml10 mb30'][contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("9/2");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Magnet");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='address3']")).sendKeys("corporate park");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='village']")).sendKeys("Machkal");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='tehsil']")).sendKeys("Mudhole");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='district']")).sendKeys("Nirmal");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='state']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[contains(text(),'Assam')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='city']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys("380015");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-blue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-blue cap-txt']")).click();
		Thread.sleep(3000);*/
     //Create Merchant
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn ftr-btn green-btn w-100']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("Test Mer");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys("Test Two");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys("Test@143");
        driver.findElement(By.xpath("//button[@class='btnpicker btnpickerenabled']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='headerlabelbtn yearlabel']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='yearchangebtn mydpicon icon-mydpup yearchangebtnenabled']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),'1983')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='headerlabelbtn monthlabel']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),'Jun')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tr[2]//td[4]//div[1]//span[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys("testme02@mailinator.com");
        Thread.sleep(5000);
        driver.findElement(By.id("phone")).sendKeys("1112228880");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@id='profile_pic_select']")).click();
        Thread.sleep(8000);
        driver.   findElement(By.xpath("//div[@class='move']")).isDisplayed();
        Thread.sleep(3000);
        //Cancel button-Profile
        //driver.findElement(By.xpath("//button[@class='btn btn-pink']")).click();
        Thread.sleep(3000);
        //Confirm button-Profile
        driver.findElement(By.xpath("//button[@id='send-mny']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='fileType']")).click();
        Thread.sleep(2000);
        // Passport->
       /* driver.findElement(By.xpath("//option[contains(text(),'Passport')]")).click();
        Thread.sleep(2000);
        // Driving License
        driver.findElement(By.xpath("//option[contains(text(),'Driving License')]")).click();
        Thread.sleep(2000);
        //Voter Id
        driver.findElement(By.xpath("//option[contains(text(),'Voter's Identity Card')]")).click();
        Thread.sleep(2000);*/
        //Aadhar-Card
        driver.findElement(By.xpath("//option[contains(text(),'Aadhar Card')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='aadhaar_front_select']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@id='aadhaar_back_select']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='step1']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Previous']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='step1']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='otp_val']")).sendKeys("91752");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-blue float-right fs-16 ml10 mb30'][contains(text(),'Next')]")).click();

    }










    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
