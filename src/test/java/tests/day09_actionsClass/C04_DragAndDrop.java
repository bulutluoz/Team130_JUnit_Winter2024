package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);

        WebElement accaptableButonElementi =
                driver.findElement(By.xpath("//*[@id='draggable2']"));

        WebElement dropHereElementi =
                driver.findElement(By.xpath("//*[@id='droppable2']"));

        ReusableMethods.bekle(1);
        actions.dragAndDrop(accaptableButonElementi,dropHereElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = dropHereElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptableButonElementi =
                driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
        dropHereElementi =
                driver.findElement(By.xpath("//*[@id='droppable2']"));

        ReusableMethods.bekle(1);

        actions.dragAndDrop(notAcceptableButonElementi,dropHereElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        expectedYazi = "Drop Here";
        actualYazi = dropHereElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(3);
    }
}
