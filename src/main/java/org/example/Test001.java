package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static java.awt.SystemColor.text;

public class Test001 {
    protected static WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");

        //open Chrome browser>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/"); }

        //TEST CASES@@@@@@@@@@@@@###################@@@@@@@@@@@@############
        @Test
         public void userShouldBeAbleToRegisterSuccessfully(){

            // click on register button>>>>>>>>>>>>>>>>>>>>>>>
            // clickOnElement(By.className("ico-register"));
             driver.findElement(By.className("ico-register")).click();

             //select gender>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             driver.findElement(By.id("gender-male")).click();


             // enter firstname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             typeText(By.xpath("//input[@name='FirstName']"),"Automation");
             //  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Automation");

             //enter lastname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             typeText(By.id("LastName"),"Tester");
             // driver.findElement(By.id("LastName")).sendKeys("Tester");

             //select date of birth>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            Select birthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
             birthday.selectByIndex(17);

             //select month>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
            birthMonth.selectByValue("6");

             //select year>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            Select birthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
             birthYear.selectByVisibleText("2000");

             //email>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             typeText(By.id("Email"),"shahsweta" +randomDate()+"9@yahoo.com");
             //  driver.findElement(By.id("Email")).sendKeys("shahsweta9@yahoo.com");

             //password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             typeText(By.id("Password"),"shwetashah");
             //  driver.findElement(By.id("Password")).sendKeys("shwetashah");

             //confirm password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             typeText(By.id("ConfirmPassword"),"shwetashah");
             // driver.findElement(By.id("ConfirmPassword")).sendKeys("shwetashah" );

             // click on register>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
             clickOnElement(By.id("register-button"));
             //  driver.findElement(By.id("register-button")).click();


              String expectedMessage = "Your registration completed";
              String actualMessage = driver.findElement(By.className("result")).getText();
               System.out.println("Actual message:" + actualMessage);
               Assert.assertEquals(actualMessage,expectedMessage,"registration is not working");

               driver.quit();  }
    //TEST CASES@@@@@@@#########################@@@@@@@@@@@@@@@@@@@@@#############
    @Test
    public void userShouldBeAbelToAddInAddToCartProduct(){
        //click on computers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.linkText("Computers"));

        //click on Desktop>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.linkText("Desktops"));

        //click on build your own computer>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
          clickOnElement(By.linkText("Build your own computer"));

        //select the processor>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Select processor = new Select(driver.findElement(By.id("product_attribute_1")));
        processor.selectByIndex(1);

        //select Ram>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Select Ram = new Select(driver.findElement(By.id("product_attribute_2")));
        Ram.selectByIndex(1);

        //select hdd>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       driverWaitForClickable(10,By.id("product_attribute_3_6"));

       //select os>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       clickOnElement(By.id("product_attribute_4_9"));

      //select software>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       clickOnElement(By.id("product_attribute_5_11"));
        clickOnElement(By.id("product_attribute_5_12"));

       //click on add to cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.id("add-to-cart-button-1"));

        //click on shopping cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.className("cart-label"));

        //check shoppingCart URL>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String actualUrl =driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("cart"),"Your shopping cart url does not contain cart word");

        //check shoppingCart page>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String expectedMessage = "Shopping cart";
        String actualMessage = getTextFromElement(By.className("page-title"));
        Assert.assertEquals(actualMessage,expectedMessage);

        //check your own computer product available in cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String ExpectedMessage = "Build your own computer";
        String ActualMessage = getTextFromElement(By.className("product-name"));
        Assert.assertEquals(ActualMessage,ExpectedMessage);}

       // TEST CASES#########@@@@@@@@@#########@@@@@@@@@#########@@@@@@@@@#########
    @Test
    public void userShouldBeAbleToSendEmailAFriend(){
        userShouldBeAbleToRegisterSuccessfully();

        //click on continue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     // Select Continue = new Select(driver.findElement(By.linkText("button-1 register-continue-button")));
        clickOnElement(By.xpath("//a[@class=button-1 register-continue-button]"));
     //  clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //click on computers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.linkText("Computers"));

        //click on Desktop>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.linkText("Desktops"));

        //click on build your own computer>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.linkText("Build your own computer"));

        //click on email a friend>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      clickOnElement(By.xpath("//button[@class=button-2 email-a-friend-button"));

      //friend's email>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        driver.findElement(By.id("Email")).sendKeys("asasasas@gmail.com");

        //enter email  address>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        driver.findElement(By.id("Email")).sendKeys("shahsweta9@yahoo.com");

        //personal message>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        driver.findElement(By.name("PersonalMessage")).sendKeys("HELLO INDIA");

        //click on send email>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.name("send-email"));

        //check message>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String ExpectedMessage = "Your message has been sent.";
        String ActualMessage =getTextFromElement (By.className("result"));
        Assert.assertEquals(ActualMessage,ExpectedMessage); }

    //TEST CASES@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#############################

    @Test
    public void  userShouldBeAbleToChangeCurrency(){
        //click on currency drop down menu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.id("customerCurrency"));

       // select currency>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Select USDollar = new Select(driver.findElement(By.id("customerCurrency")));
        Select EURO = new Select(driver.findElement(By.id("customerCurrency"))); }

     @AfterMethod
         public void afterMethod(){driver.quit(); }

  //  public static void clickOnElement(By by){driver.findElement(by).click();}
    public static void clickOnElement(By by){driver.findElement(by).click(); }
    public static void typeText(By by, String text){driver.findElement(by).sendKeys(text);}
    public static String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyyhhmmss");
        return formatter.format(date);

    }
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public static void driverWaitForClickable( int time, By by){
        WebDriverWait wait01 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.elementToBeClickable(by)).click();

    }
    public static void driverWaitUntilContainsUrl(By by,int time, String url){
        WebDriverWait wait2 =new WebDriverWait(driver,Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.urlContains(url));
    }
    public static void driverWaitUntilPresenceOfElement(By by, int time){
        WebDriverWait wait3 =new WebDriverWait(driver,Duration.ofSeconds(time));
        wait3.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static void driverWaitUntil(int time, WebElement element){
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void driverWaitSelectElement(By by, int time){
        WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait5.until(ExpectedConditions.elementToBeSelected(by));
    }
    public static void driverWaitAttribution(int time, String Attribute, String value, By by){
        WebDriverWait wait6 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait6.until(ExpectedConditions.attributeContains(by, Attribute, value));

    }
    public static void driverWaitUrlContains(int time, String UrlContains){
        WebDriverWait wait7 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait7.until(ExpectedConditions.urlContains(UrlContains));
    }
    public static void driverWaitUrlFractions(int time,String fraction){
        WebDriverWait wait8 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait8.until(ExpectedConditions.urlContains(fraction));
    }
    public static void driverWaitTextToBe(By by, String value,int time){
        WebDriverWait wait9 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait9.until(ExpectedConditions.textToBe(by,value));
    }
    public static void driverWaitPresenceOfElementLocated(By by, int time){
        WebDriverWait wait10 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait10.until(ExpectedConditions.presenceOfElementLocated(by));

    }
    public static void driverWaitAttributeToBeNotEmpty(int time, WebElement element,String text){
        WebDriverWait wait11 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait11.until(ExpectedConditions.attributeToBeNotEmpty(element, text));
    }
    public static void driverWaitAlertsPresent(int time){
        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait12.until(ExpectedConditions.alertIsPresent());
    }
    public static void driverWaitTitleContains(int time, String name){
        WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait13.until(ExpectedConditions.titleContains(name));
    }

}














