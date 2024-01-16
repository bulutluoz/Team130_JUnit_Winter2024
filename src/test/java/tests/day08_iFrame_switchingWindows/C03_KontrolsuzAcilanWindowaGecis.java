package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

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
        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin

        //6- Sayfayi kapatin

        ReusableMethods.bekle(10);
    }
}
