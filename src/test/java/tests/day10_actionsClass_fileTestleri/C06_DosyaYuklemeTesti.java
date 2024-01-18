package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_DosyaYuklemeTesti extends TestBase {

    @Test
    public void dosyaYuklemeTesti(){

        // /Users/ahmetbulutluoz/Desktop

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        /*
            Selenium WebDriver ile calisir ve WebSayfalarinda istenen gorevleri yapar
            Ancak kendi bilgisayarimizdaki dosya yapisi icerisinde
            dosya secmek icin click YAPAMAZ

            1- upload yapacagimiz dosyanin, dosya yolunu kaydedin
            2- upload yapacagimiz sitedeki chooseFile butonunu locate edip kaydedin
            3- chooseFileButonElementi.sendKeys(yuklenecekDosyaninDosyaYolu)
         */

        WebElement chooseFileButonu= driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home")+ "/Desktop/reklam.jpeg";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.
        ReusableMethods.bekle(2);
        driver.findElement(By.id("file-submit")).click();
        ReusableMethods.bekle(2);

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement dosyaYuklendiYazisi = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(dosyaYuklendiYazisi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
