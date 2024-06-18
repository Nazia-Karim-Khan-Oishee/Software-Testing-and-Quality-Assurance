import org.junit.Assert;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {
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
    public void LogIn() {

        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");

        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://practicesoftwaretesting.com/#/account", currentUrl);

    }



}

