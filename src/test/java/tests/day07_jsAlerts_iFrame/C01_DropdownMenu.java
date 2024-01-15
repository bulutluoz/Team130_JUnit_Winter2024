package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_DropdownMenu extends TestBase {

    @Test
    public void zeroAppTesti(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
            driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//*[@*='Sign in']")).click();
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin // value : EUR
        WebElement currencyDropdownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropdownMenu);
        select.selectByValue("EUR");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("200");
        //10. “US Dollars” radio button'in secilmedigini test edin
        WebElement uSDollarsRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(uSDollarsRadioButton.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        WebElement yaziElementi = driver.findElement(By.id("alert_content"));

        String expectedYazi = "Foreign currency cash was successfully purchased.";
        String actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(2);
    }
}
