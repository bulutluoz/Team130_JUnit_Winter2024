package tests.day11_seleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){

        //1- amazon anasayfaya gidin
        driver.get("https://www.walmart.com");

        ReusableMethods.bekle(1);

        //2- tum cookie’leri listeleyin
         Set<Cookie> cookieSeti = driver.manage().getCookies();

         int siraNo=1;
        for (Cookie eachCookie: cookieSeti
             ) {
            System.out.println(siraNo+"-------" + eachCookie);
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSeti.size()>5);
        //4- ismi mobileweb olan cookie degerinin 0 oldugunu test edin
        Assert.assertEquals(driver.manage().getCookieNamed("mobileweb").getValue(),"0");
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin


        Assert.assertEquals(driver.manage().getCookieNamed("en sevdigim cookie").getValue(),"cikolatali");

        //7- ismi mobileweb olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("mobileweb");
        System.out.println("===================================");
        cookieSeti = driver.manage().getCookies();

        siraNo=1;
        boolean mobilewebVarMi = false;

        for (Cookie eachCookie: cookieSeti
        ) {
            System.out.println(siraNo+"-------" + eachCookie);
            siraNo++;

            if (eachCookie.getName().equals("mobileweb")){
                mobilewebVarMi = true;
            }

        }
        // eger mobileweb silindi ise mobilewebVarMi bu satirda false olmali
        Assert.assertFalse(mobilewebVarMi);

        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookieSeti = driver.manage().getCookies();

        Assert.assertTrue(cookieSeti.isEmpty());

    }
}
