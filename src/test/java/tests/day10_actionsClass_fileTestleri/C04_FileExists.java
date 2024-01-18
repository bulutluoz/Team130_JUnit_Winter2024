package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;


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

        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team130_JUnit
        //      /src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt
        // D:\Team130_JUnit
        //      \src\test\java\tests\day10_actionClass_fileTestleri\deneme.txt
        // C:\Users\Sony\IdeaProjects\Team130_JUnit
        //      \src\test\java\tests\day10_actionsClass_fileTestleri\deneme.txt
        // C:\Users\yakup\IdeaProjects\Team130_JUnit
        //      \src\test\java\day10_actionsClass_fileTestleri\deneme.txt
        // /C:\Users\turkm\IdeaProjects\Team130JUnit
        //      \src\test\java\tests\Day10_actionsClass_fileActions\deneme.txt

        System.out.println(System.getProperty("user.dir"));

        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team130_JUnit


        // Absolute dosya yolunuzu dinamik yapmak isterseniz

        String absoluteDosyaYolu = System.getProperty("user.dir") + "/src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(absoluteDosyaYolu)));
    }
}
