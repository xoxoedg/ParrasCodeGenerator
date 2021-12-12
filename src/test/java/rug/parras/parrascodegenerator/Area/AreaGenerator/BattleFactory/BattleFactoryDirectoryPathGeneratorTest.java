package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class BattleFactoryDirectoryPathGeneratorTest {

    @Autowired
    private BattleFactoryDirectoryPathGenerator directoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\characters\\battles\\rionnagen_test";
        String actualDirPath = directoryPathGenerator.createDirectoryPath("Rionnagen test");
        assertEquals(expectedDirPath, actualDirPath);
    }
}