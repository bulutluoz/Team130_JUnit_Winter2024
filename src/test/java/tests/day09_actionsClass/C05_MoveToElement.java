package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_MoveToElement extends TestBase {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearLinki =
                driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearLinki).perform();

        //3- “Boys” linkine basin
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//a[text()='Boys']")).click();
        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]")).click();
        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        String expectedUrunIsmi = "Boys Shirt White Color";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        ReusableMethods.bekle(3);
    }
}
