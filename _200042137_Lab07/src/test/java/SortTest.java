import org.junit.Assert;
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

public class SortTest {
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
  public void sortAtoZ() {
      driver.get("https://practicesoftwaretesting.com/#");
      WebElement dropdown = driver.findElement(By.cssSelector("[data-test='sort']"));

      Select select = new Select(dropdown);

      select.selectByValue("name,asc");

      try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      List<String> actualProductNames = new ArrayList<>();

      List<WebElement> productCards = driver.findElements(By.cssSelector(".card-body"));

      for (WebElement productCard : productCards) {
          String productName = productCard.findElement(By.cssSelector("h5[data-test='product-name']")).getText();
          System.out.println(productName);
          actualProductNames.add(productName);

      }
      for (int i = 0; i < actualProductNames.size() - 1; i++) {
        if (actualProductNames.get(i).compareToIgnoreCase(actualProductNames.get(i + 1)) > 0) {
          throw new AssertionError("Product names are not sorted in ascending order");
        }
      }

    }
    @Test
    public void sortZtoA() {
        driver.get("https://practicesoftwaretesting.com/#");
        WebElement dropdown = driver.findElement(By.cssSelector("[data-test='sort']"));

        Select select = new Select(dropdown);

        select.selectByValue("name,desc");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<String> actualProductNames = new ArrayList<>();

        List<WebElement> productCards = driver.findElements(By.cssSelector(".card-body"));

        for (WebElement productCard : productCards) {
            String productName = productCard.findElement(By.cssSelector("h5[data-test='product-name']")).getText();
            System.out.println(productName);
            actualProductNames.add(productName);

        }
        for (int i = 0; i < actualProductNames.size() - 1; i++) {
            if (actualProductNames.get(i).compareToIgnoreCase(actualProductNames.get(i + 1)) < 0) {
                throw new AssertionError("Product names are not sorted in ascending order");
            }
        }

    }

    @Test
    public void SortByPriceHighToLow() throws Exception {
        driver.get("https://practicesoftwaretesting.com/#");
        WebElement dropdown = driver.findElement(By.cssSelector("[data-test='sort']"));

        Select select = new Select(dropdown);
        select.selectByValue("price,desc");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Double> actualPrices = new ArrayList<>();

        List<WebElement> productCards = driver.findElements(By.cssSelector(".product-card"));

        for (WebElement productCard : productCards) {
            String priceString = productCard.findElement(By.cssSelector(".product-price")).getText();
            double price = Double.parseDouble(priceString); // Parse string to double
            actualPrices.add(price);
        }

        for (int i = 0; i < actualPrices.size() - 1; i++) {
            if (actualPrices.get(i) < actualPrices.get(i + 1)) {
                throw new AssertionError("Product prices are not sorted in descending order");
            }
        }

    }

    @Test
    public void SortByPriceLowtoHigh() throws Exception {
        driver.get("https://practicesoftwaretesting.com/#");
        WebElement dropdown = driver.findElement(By.cssSelector("[data-test='sort']"));

        Select select = new Select(dropdown);
        select.selectByValue("price,asc");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Double> actualPrices = new ArrayList<>();

        List<WebElement> productCards = driver.findElements(By.cssSelector(".product-card"));

        for (WebElement productCard : productCards) {
            String priceString = productCard.findElement(By.cssSelector(".product-price")).getText();
            double price = Double.parseDouble(priceString); // Parse string to double
            actualPrices.add(price);
        }

        for (int i = 0; i < actualPrices.size() - 1; i++) {
            if (actualPrices.get(i) > actualPrices.get(i + 1)) {
                throw new AssertionError("Product prices are not sorted in ascending order");
            }
        }
    }



}

