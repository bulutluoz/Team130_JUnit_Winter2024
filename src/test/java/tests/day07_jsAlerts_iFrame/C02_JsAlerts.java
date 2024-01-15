package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_JsAlerts extends TestBase {



    @Test
    public void birinciAlertTesti(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        ReusableMethods.bekle(1);
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String actualAlertYazi = driver.switchTo().alert().getText();
        String expectedAlertyazi = "I am a JS Alert";
        Assert.assertEquals(expectedAlertyazi,actualAlertYazi);
        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);
    }

    @Test
    public void ikinciAlertTesti(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        ReusableMethods.bekle(1);
        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();
        ReusableMethods.bekle(1);

        //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }



    //3.Test
    //	- https://testotomasyonu.com/javascriptAlert adresine gidin
    //	- 3.alert'e tiklayalim
    //	- Cikan prompt ekranina "Abdullah" yazdiralim
    //	- OK tusuna basarak alert'i kapatalim
    //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
}
