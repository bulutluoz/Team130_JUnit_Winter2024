package tests.day12_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikHtmlKodlariDisindaOlusturulanWebTables  extends TestBase {

    @Test
    public void test01(){
        // (//*[@role='trow'])/ *[@role='tdata']

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        //  2. Headers da bulunan basliklari yazdirin
        WebElement baslikSatirElementi =
                driver.findElement(By.xpath("(//*[@role='hrow'])"));

        System.out.println(baslikSatirElementi.getText());

        //  3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunbaslikElementi =
                driver.findElement(By.xpath("(//*[@role='hdata'])[3]"));

        System.out.println(ucuncuSutunbaslikElementi.getText());
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleriList =
                driver.findElements(By.xpath("(//*[@role='tdata'])"));

        System.out.println(ReusableMethods.stringListeCevir(tabloDataElementleriList));

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        System.out.println("tablodaki cell sayisi : " + tabloDataElementleriList.size());
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("(//*[@role='trow'])"));

        System.out.println("tablodaki satir sayisi : " + satirElementleriList.size());
        //  7. Tablodaki sutun sayisini yazdirin

        List<WebElement> ikinciSatirDataElementleriList =
                driver.findElements(By.xpath("(//*[@role='trow'])[2]/ *[@role='tdata']"));

        System.out.println("Tablodaki sutun sayisi : " + ikinciSatirDataElementleriList.size());

        //  8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunElementlerList =
                driver.findElements(By.xpath("(//*[@role='trow'])/ *[@role='tdata'][3]"));

        System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunElementlerList));

        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

        ReusableMethods.bekle(3);
    }
}
