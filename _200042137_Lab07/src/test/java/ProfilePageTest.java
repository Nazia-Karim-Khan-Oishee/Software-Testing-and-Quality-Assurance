import org.junit.Assert;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProfilePageTest {
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
    public void TestProfile() {

        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");

        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement profileButton = driver.findElement(By.cssSelector("a[data-test='nav-profile']"));
        profileButton.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://practicesoftwaretesting.com/#/account/profile", currentUrl);

    }
    @Test
    public void TestUpdateProfile() throws InterruptedException {

        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");

        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();


            Thread.sleep(5000);

        WebElement profileButton = driver.findElement(By.cssSelector("a[data-test='nav-profile']"));
        profileButton.click();
       Thread.sleep(7000);

        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-profile/div/form[1]/div[2]/div[1]/div[4]/div/input")).sendKeys("01324456789");
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-profile/div/form[1]/div[2]/div[2]/div[2]/div/input")).sendKeys("123");
        driver.findElement(By.ByXPath.xpath("/html/body/app-root/div/app-profile/div/form[1]/div[2]/div[2]/div[4]/div/input")).sendKeys("XY");

        Thread.sleep(2000);

        WebElement updateProfileButton = driver.findElement(By.cssSelector("button[data-test='update-profile-submit']"));

        updateProfileButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert.alert-success")));

        if (successMessage.getText().contains("successfully updated")) {
            System.out.println("Update Profile successful!");
        } else {
            System.out.println("Update Profile failed!");
        }
    }



}

