
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchBarTest {
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
    public void SearchTest() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#/");
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[1]/form[2]/div/input")).sendKeys("Pliers");

        Thread.sleep(1000);
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[1]/form[2]/div/button[2]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> productNames = driver.findElements(By.cssSelector("div a div h5[data-test='product-name']"));
       for(WebElement product:productNames){
           if(!product.getText().contains("Pliers"))
           {
               System.out.println(product.getText());
               Assertions.fail("Product name does not contain Pliers");
           }
       }

    }

}

