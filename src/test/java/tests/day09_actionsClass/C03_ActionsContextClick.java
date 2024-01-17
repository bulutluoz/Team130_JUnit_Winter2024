package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_ActionsContextClick extends TestBase {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();
        ReusableMethods.bekle(1);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazi = "You selected a context menu";
        String actualAlertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        //   link tikladiginda yeni bir tab aciliyor,
        //   o tab'a gecmek icin C01'deki method'u kullanalim

        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        ReusableMethods.titleIleWindowDegistir("Elemental Selenium | Elemental Selenium",driver);

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        WebElement h1TagElementi = driver.findElement(By.tagName("h1"));
        String expectedYazi= "Make sure your code lands";
        String actualYazi = h1TagElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(2);
    }
}
