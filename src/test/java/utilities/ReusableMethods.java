package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<String> stringListeCevir(List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : webElementList
             ) {

            stringList.add(eachElement.getText());
        }

        return stringList;
    }

    public static void titleIleWindowDegistir(String hedefTitle, WebDriver driver){

        Set<String> whdSeti = driver.getWindowHandles();


        for (String eachWhd : whdSeti
        ) {
            driver.switchTo().window(eachWhd);

            String oldugumuzSayfaTitle = driver.getTitle();

            if (oldugumuzSayfaTitle.equals(hedefTitle)){

                break;
            }
        }

    }

    public static void tumSayfaSreenshot(WebDriver driver)  {
        // 1- bir TakesScreenShot objesi olusturun ve deger olarak driver'i atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenshot'i kaydedecegimiz bir dosya olusturalim
        //    screenshot ismini unique yapabilmek icin, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now(); // 2024-01-24T19:01:05.777116
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati); // 240124190341


        File tumSayfaScreenshot = new File("target/tumSayfaScreenshot/tumSayfa"+timeStamp+".jpeg");

        // 3- tss objesini kullanarak screenshot alin ve bir File olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi deger olarak asil kaydedilecek File'a kopyalayin

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void tumSayfaSreenshot(WebDriver driver,String resimAdi)  {
        // 1- bir TakesScreenShot objesi olusturun ve deger olarak driver'i atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenshot'i kaydedecegimiz bir dosya olusturalim

        File tumSayfaScreenshot = new File("target/tumSayfaScreenshot/tss"+resimAdi+".jpeg");

        // 3- tss objesini kullanarak screenshot alin ve bir File olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi deger olarak asil kaydedilecek File'a kopyalayin

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
