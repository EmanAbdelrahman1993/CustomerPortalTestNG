package stepDefs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class Hooks {
    public static WebDriver driver;
    public static Assertion softAssert = new SoftAssert();


    public static void loginButton()  {
        driver.findElement(By.id("login-button")).click();
    }
    public static void logoutButton()  {
        driver.findElement(By.id("logout-btn")).click();
    }
    public static void profileIcon()
    {
        Hooks.driver.findElement(By.xpath("//*[@id=\"nav-collapse\"]/div/div[2]/ul/li[1]/a")).click();
    }

    //Rechrge Meter:
    public static void rechageMeterTab()
    {
        Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[1]/div[2]/span")).click();
    }

    public static WebElement meterCode()
    {
        return Hooks.driver.findElement(By.id("meter_code"));
    }
    public static WebElement accountReference()
    {
        return Hooks.driver.findElement(By.id("account_reference"));
    }
    public static WebElement rechargeValue()
    {
        return Hooks.driver.findElement(By.id("recharge_value"));
    }

    public static void rechageButton()
    {
        Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/form/div[2]/button")).click();
    }
    public static void payButton()
    {
        Hooks.driver.findElement(By.xpath("//*[@id=\"paymentConfirmation___BV_modal_footer_\"]/div/button[2]")).click();
    }
    public static void cancelButton(){
        Hooks.driver.findElement(By.xpath("//*[@id=\"paymentConfirmation___BV_modal_footer_\"]/div/button[1]")).click();
    }
/*
    public static WebElement cardNumber()
    {
        return Hooks.driver.findElement(By.id("cardNumber"));
    }
    public static WebElement expiryMonth()
    {
        return Hooks.driver.findElement(By.id("expiryMonth"));
    }

    public static WebElement expiryYear()
    {
        return Hooks.driver.findElement(By.id("expiryYear"));
    }

    public static WebElement cardHolderName()
    {
        return Hooks.driver.findElement(By.id("cardHolderName"));

    }
    public static WebElement csc()
    {
        return Hooks.driver.findElement(By.id("csc"));
    }

    public static void NextButton()
    {
        Hooks.driver.findElement(By.xpath("//*[@id=\"button-row1\"]/button[4]")).click();
    }
*/
    //Home page Elements
    public static void electricMeterButton() {
        String test = driver.findElement(By.xpath("//*[@id=\"__BVID__155___BV_tab_button__\"]")).getText();
        System.out.println(test);
    }

    public static void waterMeterButton(){
        Hooks.driver.findElement(By.linkText("201009000163")).click();
    }

    public static void showReceiptButton() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div/div[2]/div/div/table/tr[2]/td[4]/a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void downloadReciept() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[1]/button/span")).click();
        Thread.sleep(3000);
    }
    public static void backButton()
    {
        Hooks.driver.findElement(By.className("back")).click();
    }
    //*[@id="app"]/div/div[2]/div[1]/a

    public static void BackToLoginLink() {
        Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/p/a")).click();
    }
    public static void backLink()
    {
        Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/a")).click();
    }

    public static void submitRequest() {
        Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/button")).click();

    }

    //Complaint- Inquiry
    public static void selectComplaintService()
    {
        driver.findElement(By.id("complaint")).click();
    }
    public static void selectInquiryService()
    {
        driver.findElement(By.id("inquiry")).click();
    }

    public static void cancelService() throws InterruptedException {
        driver.findElement(By.className("close")).click();
        Thread.sleep(3000);
    }
    public static void cancelServiceButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"modal-lg___BV_modal_footer_\"]/button[1]")).click();
        Thread.sleep(3000);

    }
    public static void oKButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"modal-lg___BV_modal_footer_\"]/button[2]")).click();
        Thread.sleep(3000);
    }


    public static void sendComplaint()
    {
        driver.findElement(By.id("complaint-submit-button")).click();
    }


    public static void complaintTab()
    {
        driver.findElement(By.id("inquiry-complaint-button")).click();
    }


    public static void ResetBySMS()
    {
        driver.findElement(By.className("sms-btn")).click();
    }
    public static void ResetByEmail()
    {
        driver.findElement(By.className("email-btn")).click();
    }
    public static WebElement phoneNumber() {
        return driver.findElement(By.id("phone_number"));
    }

    public static WebElement clientCode() {
        return driver.findElement(By.id("customer-email"));
    }

    public static WebElement password() {
        return driver.findElement(By.id("password"));
    }


    public static void forgetPassLink() {
        driver.findElement(By.className("forgot-pass")).click();
    }

    //Request Elements
    public static void requestButton()
    {
        driver.findElement(By.xpath("//*[@id=\"nav-collapse\"]/ul/li/a/button")).click();
    }
    public  static void downloadButton()
    {
        driver.findElement(By.id("docs-download-btn")).click();
    }
    public static WebElement customerEmail()
    {
        return driver.findElement(By.id("customer-email"));
    }
}
