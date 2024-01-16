package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_IFrame extends TestBase {

    @Test
    public void iFrameTesti(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        //   kullanacagimiz elementin locate'inden %100 emin olmamiza ragmen
        //   NoSuchElementException verdi
        //   Kontrol ettigimizde kullanacagimiz elementin bir iframe icerisinde oldugunu gorduk
            // 1. adim : gecis yapacagimiz iframe'i locate etmek
            WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));
            // 2.adim : locate ettigimiz iframe'e gecis yapalim
            driver.switchTo().frame(electronicsIframe);
            // 3.adim : iframe icindeki elementleri kullan

        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));
        Assert.assertTrue(electronicsProductsElementi.isDisplayed());
        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellIsimElementi = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));
        String expectedIsim = "DELL Core I3 11th Gen";
        String actualIsim = dellIsimElementi.getText();

        Assert.assertEquals(expectedIsim,actualIsim);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’
        //   içeren en az 1 urun olduğunu test edin

        // urunler baska bir iframe icinde oldugundan, once o iframe'e gecis yapalim
        // ANCAK ustteki testleri sol bolumde bulunan farkli bir iframe'de yapmistik
        // sagdaki iframe'i locate etmeye calismadan once,
        // gecis yaptigimiz soldaki iframe'den, anasayfaya donmeliyiz

        driver.switchTo().defaultContent();

        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));
        driver.switchTo().frame(fashionIframe);

        List<WebElement> menSlimFitElementler = driver.findElements(By.xpath("//p[contains(text(),'Men Slim Fit')]"));

        Assert.assertTrue(menSlimFitElementler.size()>0);

        //5- Fashion yazisinin gorunur olduğunu test edin

        WebElement fashionYaziElementi = driver.findElement(By.tagName("h2"));

        String expectedYazi = "Fashion";
        String actualYazi = fashionYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        // 6- Here are some products. yazisinin gorunur oldugunu test edin
        //    yazi anasayfada oldugundan, once iFrame'den anasayfaya donmeliyiz
        driver.switchTo().defaultContent();

        WebElement hereAreSomeProductsElementi= driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreSomeProductsElementi.isDisplayed());

        ReusableMethods.bekle(2);
    }
}
