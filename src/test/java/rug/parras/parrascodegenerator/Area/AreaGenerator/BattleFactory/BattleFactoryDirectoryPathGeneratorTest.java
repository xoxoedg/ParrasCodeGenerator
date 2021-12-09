package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BattleFactoryDirectoryPathGeneratorTest {

    @Autowired
    BattleFactoryDirectoryPathGenerator directoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\Rionnagen";
        String actualDirPath = directoryPathGenerator.createDirectoryPath("Rionnagen");
        System.out.println(actualDirPath);
        assertEquals(expectedDirPath,actualDirPath);
        File directoryToDelete = new File(expectedDirPath);
        directoryToDelete.delete();
    }
}