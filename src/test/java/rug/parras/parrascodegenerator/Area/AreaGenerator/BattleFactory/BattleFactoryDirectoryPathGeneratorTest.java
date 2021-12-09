package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class BattleFactoryDirectoryPathGeneratorTest {

    @Autowired
    BattleFactoryDirectoryPathGenerator directoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\characters\\battles\\rionnagen";
        String actualDirPath = directoryPathGenerator.createDirectoryPath("Rionnagen");
        assertEquals(expectedDirPath,actualDirPath);
    }
}