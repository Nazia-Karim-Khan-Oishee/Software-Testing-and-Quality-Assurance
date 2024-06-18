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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FilterTest {
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
    public void filterHandTools() {
        List<String> productList = new ArrayList<>();
        productList.add("Hammer");
        productList.add("Hand");
        productList.add("Saw");
        productList.add("Wrench");
        productList.add("Screwdrivers");
        productList.add("Pliers");
        productList.add("Chisels");
        productList.add("Measures");
        driver.get("https://practicesoftwaretesting.com/#");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkbox = driver.findElement(By.ByXPath.xpath("//*[@id=\"filters\"]/div[2]/label/input"));
        checkbox.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> productCards = driver.findElements(By.cssSelector("div a div h5[data-test='product-name']"));

        // Loop through each product card element
        for (WebElement productCard : productCards) {
            String cardTitleText = productCard.getText().trim().toLowerCase();

            boolean containsAtLeastOne = false;

            // Check if the title text contains at least one word from productList (case-insensitive)
            for (String product : productList) {
                if (cardTitleText.contains(product.toLowerCase())) {
                    containsAtLeastOne = true;
                    break; // Exit inner loop if a match is found
                }
            }

            if (!containsAtLeastOne) {
                throw new RuntimeException("Product card title '" + cardTitleText + "' does NOT contain any item from the product list");
            }

            System.out.println("Product Card Title: " + cardTitleText); // Print even for successful matches
        }


    }

    @Test
    public void BrandTest() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 350)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-overview/div[3]/div[1]/div[6]/label/input")).click();

        Thread.sleep(1000);

        List<WebElement> images = driver.findElements(By.cssSelector("img.card-img-top"));
        int imageCount = images.size();

        Assertions.assertTrue(imageCount == 9);



    }

}

