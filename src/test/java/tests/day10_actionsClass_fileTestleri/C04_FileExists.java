package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {

    @Test
    public void test01(){

        // projemiz altinda deneme.txt dosyasinin varoldugunu test edin

        String dosyaYolu = "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        // "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt"
        // "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt"
        // "src/test/java/tests/day10_actionsClass_fileTests/deneme.txt
        // "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt"


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
