package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DevMerchant {

    WebDriver driver;
    WebDriverWait wait;

    public static void main(String[] args) {
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\InCashMe-16\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dev.Merchant.incashme.com/ua/login");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }
    //Terms & Condition and Privacy Policy
    @Test(enabled = false)
    public void TermsCondition() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Terms & Condition']")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        // Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
        // Thread.sleep(5000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        driver.switchTo().window(tabs1.get(0));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //ForgotPassword
    @Test(enabled = false)
    public void ForgotPassword() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Back to Login?')]")).click(); // Back to Login
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='emailIdFg']")).sendKeys("pnagesh12@mailinator.com"); // Enter Email Id
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn lgn-btn']")).click(); // Submit Button
        Thread.sleep(9000);
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // OK Pop-Up Button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='otp']")).sendKeys("91752");
        Thread.sleep(5000);
        // driver.findElement(By.xpath("//a[@class='color-green']")).click(); //ResendOTP
        // driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // OK Pop-Up Button

        driver.findElement(By.xpath("//button[@class='btn lgn-btn']")).click(); // Submit Button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // Success Ok Button
    }

    //Login
    @Test(enabled = true ,priority = 0)
    public void Login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("pnagesh12@mailinator.com");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Nagesh@15");
        driver.findElement(By.xpath("//button[@class='btn lgn-btn']")).click();

    }












    @AfterClass
    public void tearDown() {
        driver.quit();
    }





}
