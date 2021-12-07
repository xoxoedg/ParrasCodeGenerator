package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BattleFactoryDirectoryPathGeneratorTest {

    @Autowired
    BattleFactoryDirectoryPathGenerator directoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "C:\\Users\\rugya\\PycharmProjects\\parras\\parrastest\\src\\characters\\battles\\Rionnagen";
        String actualDirPath = directoryPathGenerator.createDirectoryPath("Rionnagen");
        System.out.println(actualDirPath);
        assertEquals(expectedDirPath,actualDirPath);
    }
}