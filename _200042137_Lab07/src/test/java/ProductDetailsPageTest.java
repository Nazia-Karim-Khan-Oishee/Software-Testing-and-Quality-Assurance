import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsPageTest {
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
    public void ProductDetails() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector(".fa-plus")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("2", driver.findElement(By.ByXPath.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[5]/a/span")).getText());


        driver.findElement(By.cssSelector("*[data-test=\"add-to-favorites\"]")).click();
        try {
            Thread.sleep(1000); // Wait for 1 second
            WebElement toastElement = driver.findElement(By.cssSelector("app-toasts"));
            String toastText = toastElement.getText();

            Assert.assertFalse(toastText.contains("false"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}

