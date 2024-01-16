package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C04_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement textElementi = driver.findElement(By.xpath("//*[text() = 'Add/Remove Elements']"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = textElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
        String ilkWindowWHD = driver.getWindowHandle();

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();
        //● Electronics sayfasinin acildigini test edin

        // kontrolsuz tab acildigi icin, ikinci window'un WHD'ini bulup, o window'a gecmeliyiz
        Set<String> whdSeti = driver.getWindowHandles();

        String ikinciWindowWHD = "";

        for (String eachWhd : whdSeti
             ) {

            if (!eachWhd.equals(ilkWindowWHD)){
                ikinciWindowWHD = eachWhd;
            }
        }

        // artik ikinci window'a gecis yapabiliriz
        driver.switchTo().window(ikinciWindowWHD);

        String expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Bulunan urun sayisinin 16 olduğunu test edin

        List<WebElement> urunElementleriList = driver.findElements(By.xpath("//*[@class='product-box mb-2 pb-1']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = urunElementleriList.size();

        Assert.assertEquals(expectedUrunSayisi,actualUrunSayisi);

        //● Ilk actiginiz addremove sayfasina donun

        driver.switchTo().window(ilkWindowWHD);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}







