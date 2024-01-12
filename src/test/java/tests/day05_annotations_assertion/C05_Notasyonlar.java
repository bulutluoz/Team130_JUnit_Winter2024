package tests.day05_annotations_assertion;

import org.junit.*;

public class C05_Notasyonlar {

    @BeforeClass
    public static void setupClass(){
        System.out.println("Beforeclass calisti");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Afterclass calisti");
    }

    @Before
    public void setup(){
        System.out.println("Before methodu calisti");
    }

    @After
    public void teardown(){
        System.out.println("After methodu calisti");
    }

    @Test
    public void test01(){
        System.out.println( "test01 calisti");
    }

    @Test
    public void test02(){
        System.out.println( "test02 calisti");
    }

    @Test
    public void test03(){
        System.out.println( "test03 calisti");
    }
}
