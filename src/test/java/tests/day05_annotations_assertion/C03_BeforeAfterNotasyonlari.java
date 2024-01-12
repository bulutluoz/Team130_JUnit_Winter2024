package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterNotasyonlari {

    // uc farkli test method'unda verilen sayfalara gidin
    // o sayfaya gidildigini test edin ve sayfayi kapatin

    /*
        Eger bir class'da her test method'undan once calismasini istediginiz kodlar var ise
        bunu saglamak icin @Before notasyonuna sahip bir method olusturabiliriz

        Eger bir class'da her test method'u calistiktan sonra calismasini istediginiz kodlar var ise
        bunu saglamak icin @After notasyonuna sahip bir method olusturabiliriz
     */


    WebDriver driver;
    @Before
    public void setup(){
        System.out.println("@Before calisti");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void teardown(){
        System.out.println("@After calisti");
        driver.quit();
    }


    @Test
    public void testOtomasyonuTest(){
        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test otomasyonu testi PASSED");
        }else System.out.println("Test otomasyonu testi FAILED");

    }
    @Test
    public void wisequarterTest(){

        driver.get("https://www.wisequarter.com/");

        String expectedUrl = "https://wisequarter.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Wisequarter testi PASSED");
        }else {
            System.out.println("Wisequarter testi FAILED");
        }

    }
    @Test
    public void youtubeTest(){

        driver.get("https://www.youtube.com/");

        String expectedUrl = "https://www.youtube.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");

    }
}
