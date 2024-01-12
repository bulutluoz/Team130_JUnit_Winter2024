package tests.day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C04_TestBaseKullanimi extends TestBase {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");
        // sayfaya gittiginizi test edin

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
