package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_TestOtomasyonuRegister extends TestBase {

    @Test
    public void kayitOlusturmaTesti(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath(" //a[text()=' Sign Up']"))
                .click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys("wise")
                .sendKeys(Keys.TAB)
                .sendKeys("Quarter")
                .sendKeys(Keys.TAB)
                .sendKeys("wisequarter@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();
        //Sign Up butonuna basalim
        ReusableMethods.bekle(1);
        driver.findElement(By.id("btn-submit-form")).click();

        //5- Kaydin olusturuldugunu test edin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));

        emailKutusu.sendKeys("wisequarter@gmail.com");

        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));

        passwordKutusu.sendKeys("12345");

        WebElement signInButonu = driver.findElement(By.xpath("//*[@id='submitlogin']"));

        signInButonu.click();


        WebElement uyeEmailElementi= driver.findElement(By.xpath("//p[text()='wisequarter@gmail.com']"));

        Assert.assertTrue(uyeEmailElementi.isDisplayed());

        ReusableMethods.bekle(1);

    }
}
