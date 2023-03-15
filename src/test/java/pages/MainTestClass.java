package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import stepDefs.Hooks;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static stepDefs.Hooks.downloadButton;
import static stepDefs.Hooks.driver;

public class MainTestClass {

    static WebElement RechargeButtonEnabled;
    @Test(priority = 99)
    public static void logoutUser() throws InterruptedException {
        //driver.navigate().to("https://cp.pylonump.com/login");
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("EARKGSB001");
        Hooks.password().clear();
        Hooks.password().sendKeys("23020006");
        Hooks.loginButton();
        Thread.sleep(3000);
        driver.findElement(By.id("logout-btn")).click();
        Thread.sleep(3000);
        String actualUrl="https://cp.pylonump.com/login";
        String expectedUrl= Hooks.driver.getCurrentUrl();
        Thread.sleep(3000);
        //Assertion softAssert = new SoftAssert();
        Assert.assertTrue(actualUrl.equals(expectedUrl),"Logout Not Working");
    }
    @Test(priority = 98)
    public static void validloginData() throws InterruptedException {
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("EARKGSB001");
        Hooks.password().clear();
        Hooks.password().sendKeys("23020006");
        Hooks.loginButton();
        Thread.sleep(3000);
        String actualUrl="https://cp.pylonump.com/";
        String expectedUrl= Hooks.driver.getCurrentUrl();
        //  System.out.println(expectedUrl);
        // System.out.println(actualUrl);
        Thread.sleep(3000);
        //Assertion softAssert = new SoftAssert();
        Assert.assertTrue(actualUrl.equals(expectedUrl),"Invalid Login Data");
        //Hooks.logoutButton();
        Thread.sleep(2000);
    }

    @Test
    public static void invalidloginData() throws InterruptedException {
        driver.navigate().to("https://cp.pylonump.com/login");
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("48601@TMG2020");
        Hooks.password().clear();
        Hooks.password().sendKeys("230200067");
        Hooks.loginButton();
        String actualUrl="https://cp.pylonump.com";
        String expectedUrl= Hooks.driver.getCurrentUrl();
        Thread.sleep(3000);
        //Assertion softAssert = new SoftAssert();
        Assert.assertTrue(actualUrl.equals(expectedUrl),"Invalid Login Data");

    }



    @Test(priority = 100)
    public static void changeLanguageToArabic() throws InterruptedException {
        String getCurrentLang = driver.findElement(By.xpath("//*[@id=\"__BVID__14__BV_toggle_\"]/span")).getText();
        //System.out.println(getCurrentLang);
        driver.findElement(By.xpath("//*[@id=\"__BVID__14__BV_toggle_\"]/span")).click();
        if (getCurrentLang.equals("En")) {
            driver.findElement(By.linkText("ع")).click();
            //System.out.println(test);
            Thread.sleep(2000);

        }
        else
        {
            driver.quit();
        }
    }

    @Test(priority = 101)
    public static void changeLanguageToEnglish() throws InterruptedException {
        String getCurrentLang;
        getCurrentLang = driver.findElement(By.xpath("//*[@id=\"__BVID__14__BV_toggle_\"]/span")).getText();
        //System.out.println(getCurrentLang);
        driver.findElement(By.xpath("//*[@id=\"__BVID__14__BV_toggle_\"]/span")).click();
        if (getCurrentLang.equals("ع")) {
            driver.findElement(By.linkText("EN")).click();
            //System.out.println(test);
            Thread.sleep(2000);
        } else
            //System.out.println();
            Assert.assertEquals(getCurrentLang.equals("EN"),"English Language is already activated!");

    }
    //Forget the password
    //Forget Password By SMS
    @Test
    public static void forgetPasswordBySMSWithValidData() throws InterruptedException {
        driver.navigate().to("https://cp.pylonump.com/forgot-pass");
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("EARKGSB001");
        Hooks.phoneNumber().clear();
        Hooks.phoneNumber().sendKeys("01157511779");
        Hooks.ResetBySMS();
        Thread.sleep(3000);
        String ActualMessage= driver.findElement(By.className("main-text")).getText();
        System.out.println(ActualMessage);
        String expectedMessage= "An SMS has been sent to you with a temporary password.";
        Assert.assertTrue(ActualMessage.contains(expectedMessage),"Please Enter a valid data");
    }
    @Test
    public static void forgetPasswordByEmailWithValidData() throws InterruptedException {
        driver.navigate().to("https://cp.pylonump.com/forgot-pass");
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("EARKGSB001");
        Hooks.phoneNumber().clear();
        Hooks.phoneNumber().sendKeys("01157511779");
        Hooks.ResetByEmail();

        Thread.sleep(3000);
        String ActualMessage= driver.findElement(By.className("main-text")).getText();
        String expectedMessage= "An Email has been sent to you";
        Assert.assertTrue(ActualMessage.contains(expectedMessage),"Please Enter a valid data");
    }

    @Test
    public static void forgetPasswordBySMSWithInvalidData() throws InterruptedException {
        driver.navigate().to("https://cp.pylonump.com/forgot-pass");
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("EARKGSB0014");
        Hooks.phoneNumber().clear();
        Hooks.phoneNumber().sendKeys("011575117");
        Hooks.ResetBySMS();
        Thread.sleep(3000);
        String ActualMessage= driver.findElement(By.className("main-text")).getText();
        //System.out.println(ActualMessage);
        String expectedMessage= "Invalid data please enter a valid Client Code and Phone Number!";
        Assert.assertTrue(ActualMessage.contains(expectedMessage),"Please Enter a valid data");
    }
    @Test
    public static void forgetPasswordByEmailWithInvalidData() throws InterruptedException {
        driver.navigate().to("https://cp.pylonump.com/forgot-pass");
        Hooks.clientCode().clear();
        Hooks.clientCode().sendKeys("EARKGSB0046");
        Hooks.phoneNumber().clear();
        Hooks.phoneNumber().sendKeys("011575117");
        Hooks.ResetByEmail();
        Thread.sleep(3000);
        String ActualMessage= driver.findElement(By.className("main-text")).getText();
        //System.out.println(ActualMessage);
        String expectedMessage= "Invalid data please enter a valid Client Code and Phone Number!";
        Assert.assertTrue(ActualMessage.contains(expectedMessage),"Please Enter a valid data");

    }
    @Test
    public static void BackLink() throws InterruptedException {
        Hooks.forgetPassLink();
        Thread.sleep(3000);
        Hooks.backButton();
    }



    //visitor Recharge the meter

    //visitor access the request form


    @Test
    public void BackToLoginLink() throws InterruptedException {
        Hooks.requestButton();
        Thread.sleep(3000);
        Hooks.backButton();
    }

    //Recharge Meter:

    public boolean rechargeButtonEnable()
    {
        RechargeButtonEnabled = Hooks.driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/form/div[2]/button"));
        if(RechargeButtonEnabled.isEnabled()) {
            return true;
        }
        else
        {
            System.out.println("Button is disabled");
            return false;
        }
    }
    @Test(priority = 96)
    public void rechargeMeterWithValidData() throws InterruptedException {
        Hooks.rechageMeterTab();
        Hooks.meterCode().clear();
        Hooks.meterCode().sendKeys("13156578");
        Hooks.accountReference().clear();
        Hooks.accountReference().sendKeys("E0100190390C");
        Hooks.rechargeValue().clear();
        Hooks.rechargeValue().sendKeys("200");
        if(rechargeButtonEnable())
        {
            //System.out.println("enabled");
            Hooks.rechageButton();
            Thread.sleep(2000);
            Hooks.payButton();
            Thread.sleep(4000);
            /*
            Hooks.cardNumber().clear();
            Hooks.cardNumber().sendKeys("5500-0055-5555-5559");
            Hooks.expiryMonth().clear();
            Hooks.expiryMonth().sendKeys("01");
            Hooks.expiryYear().clear();
            Hooks.expiryYear().sendKeys("25");
            Hooks.cardHolderName().clear();
            Hooks.cardHolderName().sendKeys("TTTT");
            Hooks.csc().clear();
            Hooks.csc().sendKeys("100");
            Hooks.NextButton();
            Thread.sleep(5000);

             */
        }
        else
            System.out.println("Please Enter a valid data");
    }

    @Test(priority = 95)
    public void rechargeMeterWithInvalidData() throws InterruptedException {

        Hooks.rechageMeterTab();
        Hooks.meterCode().clear();
        Hooks.meterCode().sendKeys("131565788");
        Hooks.accountReference().clear();
        Hooks.accountReference().sendKeys("E010019039");
        Hooks.rechargeValue().clear();
        Hooks.rechargeValue().sendKeys("50");
        if(rechargeButtonEnable())
        {
            System.out.println("enabled");
            Hooks.rechageButton();
            Thread.sleep(2000);
            Hooks.payButton();
            Thread.sleep(2000);
        }
        else{
            Assert.assertTrue(rechargeButtonEnable(),"Please Enter a valid data");
        }

    }

    @Test(priority = 88)
    public void rechargeMeterWithBlankFields() throws InterruptedException {

        Hooks.rechageMeterTab();
        Hooks.meterCode().clear();
        Hooks.meterCode().sendKeys("");
        Hooks.accountReference().clear();
        Hooks.accountReference().sendKeys("");
        Hooks.rechargeValue().clear();
        Hooks.rechargeValue().sendKeys("");
        if(rechargeButtonEnable())
        {
            System.out.println("enabled");
            Hooks.rechageButton();
            Hooks.payButton();

        }
        else
            Assert.assertTrue(rechargeButtonEnable(),"Please Enter a valid data");
    }
    @Test(priority = 93)
    public void cancelRechargeMeter() throws InterruptedException {
        Hooks.rechageMeterTab();
        Hooks.meterCode().clear();
        Hooks.meterCode().sendKeys("13156578");
        Hooks.accountReference().clear();
        Hooks.accountReference().sendKeys("E0100190390C");
        Hooks.rechargeValue().clear();
        Hooks.rechargeValue().sendKeys("200");
        if(rechargeButtonEnable())
        {
            Hooks.rechageButton();
            Thread.sleep(2000);
            Hooks.cancelButton();
            System.out.println("charge Meter is cancelled");

        }
        else
            Assert.assertTrue(rechargeButtonEnable(),"Please Enter a valid data");
    }


    //Home Page:
    @Test(priority = 200)
    public static void downloadConsumption() throws InterruptedException {
        validloginData();
        Thread.sleep(3000);
        driver.findElement(By.className("apexcharts-menu-icon")).click();
        driver.findElement(By.className("exportPNG")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("apexcharts-menu-icon")).click();
        driver.findElement(By.className("exportSVG")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("apexcharts-menu-icon")).click();
        driver.findElement(By.className("exportCSV")).click();
        Thread.sleep(3000);
        logoutUser();
    }

    @Test
    public static void showReceipt() throws InterruptedException
    {
        validloginData();
        Thread.sleep(3000);

       // driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div/div[2]/div/div/table/tr[2]/td[4]/a")).click();

        Hooks.showReceiptButton();
        Thread.sleep(3000);
        Hooks.downloadReciept();
        Thread.sleep(3000);
    }
    @Test(priority = 90)
    public  static void rechargeElectricButton() throws InterruptedException {
        validloginData();
        Thread.sleep(3000);
        //Hooks.electricMeterButton();
        driver.findElement(By.xpath("//*[@id=\"pre-recharge-btn\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("min-recahrge-amount")).sendKeys("200");
        driver.findElement(By.id("recharge-handling-btn")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"paymentConfirmation___BV_modal_footer_\"]/div/button[2]")).click();
        Thread.sleep(3000);
    }
    public  static void rechargeWaterButton(String amount) throws InterruptedException {
        Hooks.waterMeterButton();
        driver.findElement(By.xpath("//*[@id=\"pre-recharge-btn\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("enter")).click();
        driver.findElement(By.id("min-recahrge-amount")).sendKeys(amount);
        driver.findElement(By.id("recharge-handling-btn")).click();

    }


    @Test
    public static void fAQPage() throws InterruptedException {
        //Login with valid data
        validloginData();
        Thread.sleep(3000);

        WebElement faq= new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("FAQ")));
        faq.click();
        //driver.findElement(By.linkText("FAQ")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("question")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("question")).click();
        Thread.sleep(3000);
        Hooks.logoutButton();
        Thread.sleep(3000);
    }
    //Guide Page
    @Test
    public static void guidePage() throws InterruptedException {
        //Login with valid data
        validloginData();
        driver.findElement(By.linkText("Meter Screens Guide")).click();
        Thread.sleep(3000);
        Hooks.logoutButton();
        Thread.sleep(3000);
    }

    //ProfilePage
    @Test
    public static void profilePage() throws InterruptedException {
        validloginData();
        Thread.sleep(3000);
        Hooks.profileIcon();
        Thread.sleep(3000);
        changePassword("A1b3c6@2022", "12345","12345");
        Thread.sleep(3000);
        Hooks.logoutButton();
        Thread.sleep(3000);
    }

    public static void changePassword(String currentPassword , String newPassword , String confirmedPassword) throws InterruptedException {
        driver.findElement(By.id("form-input-current_password")).sendKeys(currentPassword);
        driver.findElement(By.id("form-input-password")).sendKeys(newPassword);
        driver.findElement(By.id("form-input-repassword")).sendKeys(confirmedPassword);
        driver.findElement(By.id("update-personal-info-btn")).click();
        Thread.sleep(3000);
        String feedback = driver.findElement(By.id("password-live-feedback")).getText();
        String expectedText = "Your Password changed correctly!";
        Assert.assertTrue(feedback.contains(expectedText),"Please Enter a valid password");
        Thread.sleep(3000);

    }
    //Notification Page
    @Test
    public static void notifications() throws InterruptedException {
        validloginData();
        driver.findElement(By.xpath("//*[@id=\"nav-collapse\"]/div/div[2]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Notification Settings")).click();
        Thread.sleep(2000);
        updateNotification(0 , "100", "8855224", "test@test");
        Thread.sleep(3000);
        updateNotification(0 , "", "8855224", "test@test");
        Thread.sleep(3000);
        updateNotification(0 , "120", "8855224", "test@test");
        Thread.sleep(3000);
    }


    public static void updateNotification(int meterIndex, String amount , String mobile , String email) throws InterruptedException {
        Select drpCountry = new Select(driver.findElement(By.id("meter-code")));

        drpCountry.selectByIndex(meterIndex);
        Thread.sleep(2000);
        driver.findElement(By.id("critical-amount")).clear();
        driver.findElement(By.id("critical-amount")).sendKeys(amount);
        driver.findElement(By.id("mobile-input")).clear();
        driver.findElement(By.id("mobile-input")).sendKeys(mobile);
        driver.findElement(By.id("email-input")).clear();
        driver.findElement(By.id("email-input")).sendKeys(email);
        //Thread.sleep(3000);

        WebElement element = driver.findElement(By.id("update-notify-btn"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }

    //Request Page

    @Test(priority = 103)
    public void requestOption() throws InterruptedException {
        Hooks.requestButton();
        Thread.sleep(3000);
        WebElement selectElement = driver.findElement(By.id("request-option"));
        Select selectItem = new Select(selectElement);
        selectItem.selectByIndex(0);
        Thread.sleep(3000);
        selectItem.selectByIndex(1);
        Thread.sleep(3000);
        Hooks.backLink();
        Thread.sleep(3000);
        Hooks.requestButton();
        Thread.sleep(2000);
        Hooks.BackToLoginLink();
        Thread.sleep(2000);
    }

    @Test
        public void loggedUserRequest() throws InterruptedException {
        validloginData();
        driver.findElement(By.linkText("Requests")).click();
        WebElement selectElement = driver.findElement(By.id("request-option"));
        Select select = new Select(selectElement);
        select.selectByIndex(0);
        Hooks.submitRequest();
        Thread.sleep(3000);
        Hooks.logoutButton();
        Thread.sleep(3000);
    }

    //Complaint-Inquiry
    @Test(priority = 102)
    public void sendComplaint() throws InterruptedException {
        //Login with valid data
        validloginData();
        Thread.sleep(2000);
        Hooks.complaintTab();
        checkService("complaint");
        checkMeterCode(0);
        selectSubject(1);
        complaintMessage().sendKeys("test");
        Hooks.sendComplaint();
        Thread.sleep(3000);
        String feedback = driver.findElement(By.xpath("//*[@id=\"modal-lg___BV_modal_body_\"]/div/div")).getText();
        String expectedText = "Success";
        Assert.assertTrue(feedback.contains(expectedText),"Your complaint has an invalid data , Please try again");
        Thread.sleep(3000);
    }
    @Test(priority = 101)
    public void sendInquiry() throws InterruptedException {
        //Login with valid data
        validloginData();
        Hooks.complaintTab();
        checkService("inquiry");
        checkMeterCode(0);
        selectSubject(1);
        complaintMessage().sendKeys("test");
        Hooks.sendComplaint();
        Thread.sleep(3000);
        String feedback = driver.findElement(By.xpath("//*[@id=\"modal-lg___BV_modal_body_\"]/div/div")).getText();
        String expectedText = "Success";
        Assert.assertTrue(feedback.contains(expectedText),"Your inquiry has an invalid data , Please try again");
        Thread.sleep(3000);
    }


    public static WebElement complaintMessage() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(By.id("complaint-message"));
    }
    public static void selectSubject(int subjectIndex) throws InterruptedException
    {
        WebElement selectSubject = driver.findElement(By.id("subject"));
        Select selectSubjectCode = new Select(selectSubject);
        selectSubjectCode.selectByIndex(subjectIndex);
    }

    public static void selectMeterNo(int optionIndex) throws InterruptedException {

        WebElement selectMeter = driver.findElement(By.id("meter-code"));
        Select selectMeterCode = new Select(selectMeter);
        selectMeterCode.selectByIndex(optionIndex);
        Thread.sleep(3000);
    }

    public static void checkMeterCode(int meterCode) throws InterruptedException {
        if(meterCode == 0)
        {
            selectMeterNo(meterCode);
        }
        else if (meterCode == 1)
        {
            selectMeterNo(meterCode);
        }
        else
            quitDriver();
    }
    public static void checkService(String service) throws InterruptedException {
        if(service == "inquiry") {
            Hooks.selectInquiryService();
        }

        else if (service == "complaint")
        {
            Hooks.selectComplaintService();
        }
        else
            quitDriver();
    }
    @BeforeTest
    public static void OpenBrowser() {
        // 1- Bridge
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // 2- create object from chrome browser
        driver = new ChromeDriver(options);
        //3- Configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 4- navigate to url
        driver.get("https://cp.pylonump.com/login");
        String title = driver.getTitle();
        assertEquals("pylon", title);
    }
    @AfterTest
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
