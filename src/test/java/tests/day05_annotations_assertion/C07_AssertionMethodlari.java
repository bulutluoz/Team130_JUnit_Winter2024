package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionMethodlari {

    // gerekli ayarlamalari yapip
    // testotomasyonu sayfasina gidin
    // sayfaya gidebildiginizi test edin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");

        String expectedUrl ="https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

}
















