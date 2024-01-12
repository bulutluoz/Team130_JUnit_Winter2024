package tests.day06_assertions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C05_DropdownMenu extends TestBase {

    @Test
    public void dropdowntesti() throws InterruptedException {
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //1. Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun = new Select(gunDdm);
        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());
        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        Thread.sleep(5000);
    }
}
