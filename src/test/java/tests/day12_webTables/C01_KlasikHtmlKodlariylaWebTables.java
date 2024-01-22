package tests.day12_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_KlasikHtmlKodlariylaWebTables extends TestBase {

    @Test
    public void test01(){
        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());
        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBodyElementi.getText();
        Assert.assertTrue(actualTumBody.contains(expectedTabloIcerik));

        //4. Web table body’sindeki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirlarListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);
        //5. Tum satirlari yazdirin
        System.out.println("=====Satirlar listesi yazdiralim=====");
        List<String> satirYazilariList = ReusableMethods.stringListeCevir(satirlarListesi);
        System.out.println(satirYazilariList);
        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> ucuncuSatirDatalarList =
                driver.findElements(By.xpath("//tbody/tr[3]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = ucuncuSatirDatalarList.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunElementleriList));

        //8. Tablodaki basliklari yazdirin
        WebElement baslikElementi = driver.findElement(By.tagName("thead"));
        System.out.println("Basliklar : " + baslikElementi.getText());

        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        ReusableMethods.bekle(2);
    }


    public String dataDondur(int satirNo, int sutunNo){

        //       //tbody/tr[    4     ]/td[     1   ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]" ;

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();
    }
}
