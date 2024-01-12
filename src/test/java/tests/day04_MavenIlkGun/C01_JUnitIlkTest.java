package tests.day04_MavenIlkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class C01_JUnitIlkTest {

    public static void main(String[] args) throws InterruptedException {

        // ilk ayarlari yapin
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // chair icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("chair"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunlerListesi =
                driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunSayisi = bulunanUrunlerListesi.size();

        if (actualUrunSayisi>0){
            System.out.println("Chair testi PASSED");
        }else {
            System.out.println("Chair testi FAILED");
        }
        // Java icin arama yapin
        Thread.sleep(2000);
        aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        Thread.sleep(1000);

        // arama sonucunda urun bulunamadigini test edin
        bulunanUrunlerListesi =
                driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        actualUrunSayisi = bulunanUrunlerListesi.size();

        if (actualUrunSayisi == 0){
            System.out.println("Java testi PASSED");
        }else {
            System.out.println("Java testi FAILED");
        }

        // sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();
    }
}
