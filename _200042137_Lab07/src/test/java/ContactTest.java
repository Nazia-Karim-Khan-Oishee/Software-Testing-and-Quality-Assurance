import org.junit.Assert;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {
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
    public void TestForm() {
        try{
            driver.get("https://practicesoftwaretesting.com/#/contact");
            driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).click();
            driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).sendKeys("X");
            driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).click();
            driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).sendKeys("aad");
            driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("naziakarim@iut-dhaka.edu");
            driver.findElement(By.cssSelector("*[data-test=\"subject\"]")).click();
            {
                WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"subject\"]"));
                dropdown.findElement(By.xpath("//option[. = 'Customer service']")).click();
            }
            driver.findElement(By.cssSelector("*[data-test=\"message\"]")).click();
            driver.findElement(By.cssSelector("*[data-test=\"message\"]")).sendKeys("qwertyuioplkjhgfdsazxcvbnmjhgdt5yjmshjshghfaeqryioknbcxdethnnhjkk");
        driver.findElement(By.cssSelector("*[data-test=\"attachment\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"attachment\"]")).sendKeys("C:\\Users\\lenovo\\OneDrive\\Documents\\mpi.txt");
        driver.findElement(By.cssSelector("*[data-test=\"contact-submit\"]")).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement successMessage = driver.findElement(By.cssSelector("div[role='alert'][class='alert alert-success mt-3']"));

            // Extract the text content of the element
            String actualText = successMessage.getText().trim();

            // Expected text for assertion
            String expectedText = "Thanks for your message! We will contact you shortly.";

            assertEquals(expectedText, actualText);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    }





