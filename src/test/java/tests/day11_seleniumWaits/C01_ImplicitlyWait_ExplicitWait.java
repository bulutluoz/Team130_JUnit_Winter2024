package tests.day11_seleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Remove butonuna basin.
    //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //4. Add buttonuna basin
    //5. It’s back mesajinin gorundugunu test edin

    WebDriver driver;

    @Test
    public void implicitWaitTest(){
        // Implicit wait'in gorevini ve isleyisini daha iyi anlayabilmek icin
        // TestBase class'da yaptigimiz ayarlari burada yapalim
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //5. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }


    @Test
    public void explicitWaitTesti(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // implicitlyWait suresini 1 saniyeye indirmemizin sebebi,
        // implicitlyWait'in tolere edemeyecegi durumlarin olusmasi
        // ve bu durumlari explicitwait ile nasil asacagimizi gostermek.

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        // implicitlyWait'in tolere edemedigi durumlarda
        // explicitlywait icin WebDriverwait objesi olustururuz

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));

        /*
        wait objesine bir elemani bekletmek istedigimizde iki durum karsimiza cikar

        1- uzerinde calistigimiz webelement locate edilebiliyorsa
           once locate edip, sonra wait objesine istedigimiz durum gerceklesene kadar
           locate edilmis olan webelementi beklemesini soyleyebiliriz

        2- belirli bir zaman sonra hangi locater ile locate edebilecegimizi bildigimiz
           ama henuz gorunmedigi icin locate edemedigimiz webelementlerde
           bekleme ve locate'i birlikte yapabilir

           WebElement itsGoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

           wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));
         */


        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin

        // WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        WebElement itsBackElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));


        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }
}
