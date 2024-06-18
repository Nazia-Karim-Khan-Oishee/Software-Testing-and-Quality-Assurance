
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

public class PriceRangeTest {
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
    public void PriceTest() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#/");
        WebElement sliderHandle = driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[1]/div[1]/ngx-slider/span[5]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        int desiredValue = 1;
        int sliderWidth = sliderHandle.getSize().getWidth(); // Get slider width
        double newPosition = (desiredValue / 200.0) * sliderWidth; // Calculate new position based on value
        js.executeScript("arguments[0].style.left = '" + newPosition + "px'", sliderHandle);

        Thread.sleep(1000);
        WebElement uppersliderHandle = driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[1]/div[1]/ngx-slider/span[6]"));

        JavascriptExecutor js2 = (JavascriptExecutor) driver;

        int desiredUpperValue = 500;
        int UppersliderWidth = uppersliderHandle.getSize().getWidth(); // Get slider width
        double newUpperPosition = (desiredUpperValue / 200.0) * UppersliderWidth; // Calculate new position based on value

        js2.executeScript("arguments[0].style.right = '" + newUpperPosition + "px'", uppersliderHandle);

        Thread.sleep(2000);

        List<WebElement> productPrices = driver.findElements(By.cssSelector("span[data-test='product-price']"));
        for(WebElement product:productPrices){
            String price = product.getText().replace("$", "");
            double priceValue = Double.parseDouble(price);
            if(priceValue < 1 || priceValue > 500)
            {
                System.out.println(priceValue);
                Assertions.fail("Product price is not within the range");
            }
        }

        Thread.sleep(1000);
    }

}

