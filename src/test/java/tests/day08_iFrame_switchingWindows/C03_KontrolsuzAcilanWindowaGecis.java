package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void kontrolsuzWindowTesti(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        //   yazi iframe icinde oldugundan, once o iframe'i locate edip, oraya gecelim

        WebElement iFrameElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElementi);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assert.assertTrue(electronicsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement dellElementi = driver.findElement(By.id("dell-core"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        // click yapildiginda, kontrolsuz olarak yeni bir tab acildigindan
        // driver yeni tab'a gecmez, eski window'da kalir.
        // bu durumda ikinci sayfanin window handle degerini bulabilmek icin
        // 3 adima ihtiyacimiz var

        //  1.adim : ilk window'un WHD'ini kaydedelim
        String ilkWindowWHD = driver.getWindowHandle();

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        dellElementi.click();
        // 2.adim : click yapildiktan sonra WHD'ini kaydettigimiz ilk window'un yanina
        //          yeni bir tab acildi.
        //          getWindowHandles() kullanarak acik olan iki window'un
        //          WHD'lerini bir Set olarak kaydedelim

        Set<String> whDegerleriSeti = driver.getWindowHandles();


        // 3.adim : whDegerleriSeti ve ilkWindowWHD kullanarak
        //          ikinci Window'un WHD'ini bulup kaydedin

        String ikinciWindowWHD ="";

        for (String eachWhd: whDegerleriSeti
             ) {

            if (!eachWhd.equals(ilkWindowWHD)){
                ikinciWindowWHD = eachWhd;
            }
        }
        // artik yeni window'a switch yapabiliriz
        driver.switchTo().window(ikinciWindowWHD);
        // acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String expectedFiyat = "$399.00";
        String actualFiyat = fiyatElementi.getText();

        Assert.assertEquals(expectedFiyat,actualFiyat);

        //5- Ilk window'a donun ve "Here are some products." yazisinin gorunur olduğunu test edin
        driver.switchTo().window(ilkWindowWHD);
        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreYaziElementi.isDisplayed());

        //6- Sayfayi kapatin

        ReusableMethods.bekle(2);
    }
}
