package tests.day05_annotations_assertion;

import org.junit.Ignore;
import org.junit.Test;

public class C01_TestNotasyonu {
    /*
        @Test notasyonu siradan bir method'u
        bagimsiz olarak calistirilabilen bir test method'una donusturur

        bir class'da birden fazla test method'u varsa
        istersek her bir method'u tek basina,
        istersek de class level'dan calistirip toplu olarak calistirabiliriz

        JUnit'de test method'lari toplu calistirildiginda
        hangi siralama ile calisacagini BILEMEYIZ ve KONTROL EDEMEYIZ

        Eger calismasini istemediginiz bir test method'u varsa
        @Ignore notasyonu kullanabiliriz

     */

    @Test
    public void testOtomasyonuTest(){
        System.out.println("testOtomasyonu testi calisti");
    }
    @Test @Ignore
    public void wisequarterTest(){
        System.out.println("wisequarter testi calisti");
    }
    @Test
    public void youtubeTest(){
        System.out.println("youtube testi calisti");
    }
}
