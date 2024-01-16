package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void iFrameTesti(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        WebElement anIframeYaziElementi =
                driver.findElement(By.xpath("//*[text() ='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());

        //	- Text Box’a “Merhaba Dunya!” yazin.
        // textBox iframe icinde oldugundan once iframe'e gecis yapmaliyiz

        WebElement iFrameElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));
        ReusableMethods.bekle(1);
        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba Dunya!");
        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin
        //    gorunur oldugunu dogrulayin ve  konsolda yazisini yazdirin.

        // element anasayfada oldugundan
        // once gecis yaptigimiz iframe'den geri donelim
        driver.switchTo().defaultContent();

        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());

        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.bekle(3);


    }
}
