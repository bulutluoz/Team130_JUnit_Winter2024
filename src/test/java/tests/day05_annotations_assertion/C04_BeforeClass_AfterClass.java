package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_BeforeClass_AfterClass {

    // Uc test method'u olusturup asagidaki gorevleri tamamlayin
    // 1- Testotomasyonu sayfasina gidip, sayfaya gittigimizi test edin
    // 2- phone icin arama yapip, urun bulunabildigini test edin
    // 3- ilk urune tiklayip, urun aciklamasinda, case sensitive olmadan phone gectigini test edin

    /*
        Eger baslangic ayarlarinin en basta sadece 1 kere yapilmasini,
        test method'lari bittikten sonra da
        bitis ayarlarinin yapilmasini istiyorsaniz

        @Before ve @after YERINE
        @BeforeClass ve @AfterClass kullaniriz

        ONEMLI NOT : @BeforeClass ve @AfterClass kullanan method'lar static olmak ZORUNDADIR
     */
    static WebDriver driver;
    List<WebElement> bulunanUrunlerListesi;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }


    @Test
    public void test01(){
        // 1- Testotomasyonu sayfasina gidip, sayfaya gittigimizi test edin
        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl ="https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test otomasyonu sayfasina gitme testi PASSED");
        }else System.out.println("Test otomasyonu sayfasina gitme testi FAILED");
    }
    @Test
    public void test02(){
        // 2- phone icin arama yapip, urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunSayisi= bulunanUrunlerListesi.size();

        if (actualUrunSayisi>0){
            System.out.println("Urun bulma testi PASSED");
        }else System.out.println("Urun bulma testi FAILED");


    }

    @Test
    public void test03() throws InterruptedException {
        // 3- ilk urune tiklayip, urun aciklamasinda, case sensitive olmadan phone gectigini test edin
        bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Thread.sleep(2000);
        bulunanUrunlerListesi.get(0).click();

        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedIcerik = "phone";
        String actualAciklamaKucukHarf = urunAciklamaElementi.getText().toLowerCase();

        if (actualAciklamaKucukHarf.contains(expectedIcerik)){
            System.out.println("ilk urun testi PASSED");
        }else {
            System.out.println("ilk urun testi FAILED");
        }

    }

}
