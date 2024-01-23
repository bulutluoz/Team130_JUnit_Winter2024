package tests.day13_ExcelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshot extends TestBase {

    @Test
    public void aramaTest() throws IOException {

        // Testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Nutella icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonucunda urun bulunamadigini test edin

        WebElement aramaSonucuElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucuElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        ReusableMethods.bekle(1);
        // Testlerimiz sirasinda istersek tum sayfanin,
        // istersek de bir webelemntin goruntusunu kaydedebiliriz

        // Eger tum sayfa screenshot almak isterseniz

        // 1- bir TakesScreenShot objesi olusturun ve deger olarak driver'i atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenshot'i kaydedecegimiz bir dosya olusturalim

        File tumSayfaScreenshot = new File("target/tumSayfaScreenshot/tss.jpeg");

        // 3- tss objesini kullanarak screenshot alin ve bir File olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi deger olarak asil kaydedilecek File'a kopyalayin

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        ReusableMethods.bekle(3);
    }
}
