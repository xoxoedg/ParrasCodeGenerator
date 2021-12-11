package rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("it")
class WorldMapDirectoryPathGeneratorTest {

    @Autowired
    WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagen";
        String actualDirPath = worldMapDirectoryPathGenerator.createDirectoryPath("rionnagen");
        assertEquals(expectedDirPath, actualDirPath);
    }

    @Test
    void createSubDirectoryMapsPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagen\\maps";
        String actualDirPath = worldMapDirectoryPathGenerator.createSubDirectoryMapsPath("rionnagen");
        assertEquals(expectedDirPath, actualDirPath);
    }

    @Test
    void createSubDirectorySpritesPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagen\\sprites";
        String actualDirPath = worldMapDirectoryPathGenerator.createSubDirectorySpritesPath("rionnagen");
        assertEquals(expectedDirPath, actualDirPath);
    }

    @Test
    void createMapSubDirectoryFactoriesPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagen\\maps\\factories";
        String actualDirPath = worldMapDirectoryPathGenerator.createMapSubDirectoryFactoriesPath("rionnagen");
        assertEquals(expectedDirPath, actualDirPath);
    }
}