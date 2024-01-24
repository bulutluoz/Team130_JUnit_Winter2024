package tests.day14_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_JSExecutor extends TestBase {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Alt kisimda bulunan Best Sport Shoes bolumune kadar asagi inin

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // basligin "Best Sport Shoes For Multi Gender." oldugunu test edin

        WebElement bestSportElementi = driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));

        // jse ile istedigimiz best spor elementine kadar asagi inelim
        jse.executeScript("arguments[0].scrollIntoView();",bestSportElementi);
        ReusableMethods.bekle(3);
        String expectedBaslik = "Best Sport Shoes For Multi Gender.";
        String actualBaslik = bestSportElementi.getText();

        ReusableMethods.webelementScreenshot(bestSportElementi,"best");
        Assert.assertEquals(expectedBaslik,actualBaslik);

        jse.executeScript("alert('Bu is bu kadar!');");

        ReusableMethods.bekle(5);
    }
}
