package tests.day04_MavenIlkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_MainMethodsuzIlkTest {

    @Test
    public void mainsizTest(){

        // gerekli ayarlari yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // test otomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

    }

    @Test
    public void test02(){

    }

    @Test
    public void test03(){

    }

}
