package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }



    @Test
    public void checkboxTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckbox = driver.findElement(By.id("gridCheck5"));
        WebElement sirtAgrisiYaziElementi= driver.findElement(By.xpath("//label[@for='gridCheck5']"));

        WebElement carpintiCheckbox = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi= driver.findElement(By.xpath("//label[@for='gridCheck4']"));

        // sirt agrisini yazidan secelim, carpintiyi ise checkbox'dan secelim
        sirtAgrisiYaziElementi.click();
        carpintiCheckbox.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assert.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assert.assertTrue(carpintiCheckbox.isSelected());


        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerCheckbox.isSelected());
        Assert.assertFalse(epilepsiCheckbox.isSelected());

    }



}
