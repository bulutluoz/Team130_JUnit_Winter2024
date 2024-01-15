package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {

    @Test
    public void test01(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basicAuthElementi = driver.findElement(By.tagName("h1"));

        String expectedYazi = "Basic Auth";
        String actualYazi = basicAuthElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);


        ReusableMethods.bekle(2);
    }
}
