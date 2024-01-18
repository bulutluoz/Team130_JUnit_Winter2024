package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DosyaIndirmeTesti extends TestBase {

    @Test
    public void dosyaIndirmeTesti(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //2. logo.jpg dosyasını indirelim

        driver.findElement(By.xpath("//*[text()='logo.jpg']"))
                .click();

        ReusableMethods.bekle(3);
        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Kodumuzun herkesin bilgisayirda calisabilmesi icin
        // dosya yolunu dinamik yapmak isteriz
        // internette tikladigimiz dosya downloads klasorune indirilir

        String dinamikDosyaYolu = System.getProperty("user.home")+"/Downloads/logo.jpg";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


        // /Users/ahmetbulutluoz/Downloads
        // C:\Users\Utilisateur\Downloads
        // C:\Users\ahmet\Downloads
        // C:\Users\Sony\Downloads

        System.out.println(System.getProperty("user.home")); // /Users/ahmetbulutluoz
    }
}
