
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddtoCartTest {
    static WebDriver driver;

    @BeforeAll
    public static void beforeall()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);


    }
    @AfterAll
    public static void afterall(){
        driver.close();
    }


    @Test
    public void BuyNowPayLater() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#/");
        driver.findElement(By.cssSelector("*[data-test=\"nav-sign-in\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[1]/input")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[1]/a")).click();

            Thread.sleep(1000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[1]/a")).click();
            Thread.sleep(1000);
        Thread.sleep(1000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        Thread.sleep(2000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div[3]/input")).sendKeys("Dhaka");
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div/select")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[1]/select/option[5]")).click();
Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/select")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/select/option[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button")).click();
        Thread.sleep(2000);
        Assertions.assertEquals("Payment was successful",driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[3]")).getText());

    }

    @Test
    public void CreditCard() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#/");
        driver.findElement(By.cssSelector("*[data-test=\"nav-sign-in\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[1]/input")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();
         Thread.sleep(1000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[1]/a")).click();
        Thread.sleep(1000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        Thread.sleep(2000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/form/div[3]/input")).sendKeys("Dhaka");
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div/select")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[1]/select/option[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/input[1]")).sendKeys("0000-0000-0000-0000");
        Thread.sleep(2000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/input[2]")).sendKeys("12/2026");
        Thread.sleep(1000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/input[3]")).sendKeys("123");
        Thread.sleep(1000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/input[4]")).sendKeys("Nazia");

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)");

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button")).click();
        Thread.sleep(2000);
        Assertions.assertEquals("Payment was successful",driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[3]/div")).getText());
        Thread.sleep(2000);
    }



}

