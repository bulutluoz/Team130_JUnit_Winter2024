package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //	    - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)
        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre);
        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedHucreDegeri = "Kabil";
        String actualHucreDegeri = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedHucreDegeri,actualHucreDegeri);
        //		- Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()); // 190 son satirin index'ini verdi
        //		- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191 reel olarak kullanilan satir sayisini verir

        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        System.out.println(sayfa2.getLastRowNum()); // 21 son kullanilan satirin index'i
        System.out.println(sayfa2.getPhysicalNumberOfRows()); // 10  bos satirlari saymaz

        // System.out.println(sayfa2.getRow(23).getCell(1)); // NullPointerException

        // workbook excel dosyasinda kullanilan son satirdan sonrasini almaz
        // o satirlara ulasmak isterseniz NullPointerException verir

        // System.out.println(sayfa2.getRow(5).getCell(10)); // NullPointerException
        System.out.println(sayfa2.getRow(6).getCell(10)); // null
        // System.out.println(sayfa2.getRow(5).getCell(5)); // NullPointerException
        System.out.println(sayfa2.getRow(6).getCell(20)); // null

        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        // Excel'de ingilizce ulke ismi olarak Poland'in oldugunu test edin

        boolean polandVarMi = false;
        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("Poland")){
                polandVarMi = true;
            }
        }

        Assert.assertTrue(polandVarMi);

        // Excel'de ingilizce ismi Samoa olan ulkenin, baskent isminin Apia oldugunu test edin

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Samoa")){
                Assert.assertEquals("Apia",satirdakiBaskentIsmi);
            }
        }


        // Bu iki testi Map kullanarak da yapalim
        // bunun icin once ingilizce ulke isimleri ve baskentleri bir map yapalim

        Map<String, String> ulkelerVeBaskentler = new TreeMap<>() ;

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

           ulkelerVeBaskentler.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);
        }


        // Excel'de ingilizce ulke ismi olarak Poland'in oldugunu test edin

        Assert.assertTrue(ulkelerVeBaskentler.containsKey("Poland"));

        // Excel'de ingilizce ismi Samoa olan ulkenin, baskent isminin Apia oldugunu test edin

        Assert.assertEquals("Apia", ulkelerVeBaskentler.get("Samoa"));
    }
}
