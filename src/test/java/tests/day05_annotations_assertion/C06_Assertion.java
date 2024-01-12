package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {

    WebDriver driver;

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){

        // gerekli ayarlamalari yapip
        // testotomasyonu sayfasina gidin
        // sayfaya gidebildiginizi test edin


        /*
            JUnit'in console'da verdigi passed/failed raporu
            if else'in sonucuna bakmaz

            JUnit
                - kod sorunsuz calisip bitti ise ise PASSED
                - kod calisirken exception olusursa FAILED olarak degerlendirir
         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl = "https://www.testotomasyonu.com";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
            throw new RuntimeException();
            // exception firlatarak, if ile kontrol ettigimiz test failed oldugunda
            // JUnit'in de failed olmasini saglayabiliriz
        }

    }
}
