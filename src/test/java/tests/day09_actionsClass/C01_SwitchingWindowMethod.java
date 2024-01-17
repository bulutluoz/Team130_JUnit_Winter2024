package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C01_SwitchingWindowMethod extends TestBase {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();

        //● Sayfa başlığının(title) “Test Otomasyonu - Electronics” olduğunu doğrulayın.

        titleIleWindowDegistir("Test Otomasyonu - Electronics");

        expectedTitle = "Test Otomasyonu - Electronics";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        // Title'i "Test Otomasyonu" olan window'a geri donun

        titleIleWindowDegistir("Test Otomasyonu");

        // Add/Remove Elements yazisinin gorundugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        Assert.assertTrue(addRemoveYaziElementi.isDisplayed());

        // title'i "Test Otomasyonu - Electronics" olan window'a gecin

        titleIleWindowDegistir("Test Otomasyonu - Electronics");

        // Bulunan urun sayisinin 16 oldugunu test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        Assert.assertEquals(expectedUrunSayisi,actualUrunSayisi);

        ReusableMethods.bekle(3);

    }


    public void titleIleWindowDegistir(String hedefTitle){

        Set<String> whdSeti = driver.getWindowHandles();

        for (String eachWhd : whdSeti
             ) {
            driver.switchTo().window(eachWhd);

            String oldugumuzSayfaTitle = driver.getTitle();

            if (oldugumuzSayfaTitle.equals(hedefTitle)){
                break;
            }
        }

    }


}
