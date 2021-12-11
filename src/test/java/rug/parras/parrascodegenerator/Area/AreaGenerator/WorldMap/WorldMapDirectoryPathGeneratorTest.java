package rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class WorldMapDirectoryPathGeneratorTest {

    @Autowired
    WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagenmountain";
        String actualDirPath = worldMapDirectoryPathGenerator.createDirectoryPath("rionnagen mountain");
        assertEquals(expectedDirPath, actualDirPath);
    }

    @Test
    void createSubDirectoryMapsPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagenmountain\\maps";
        String actualDirPath = worldMapDirectoryPathGenerator.createSubDirectoryMapsPath("rionnagen mountain");
        assertEquals(expectedDirPath, actualDirPath);
    }

    @Test
    void createSubDirectorySpritesPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagenmountain\\sprites";
        String actualDirPath = worldMapDirectoryPathGenerator.createSubDirectorySpritesPath("rionnagen mountain");
        assertEquals(expectedDirPath, actualDirPath);
    }

    @Test
    void createMapSubDirectoryFactoriesPath() {
        String expectedDirPath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagenmountain\\maps\\factories";
        String actualDirPath = worldMapDirectoryPathGenerator.createMapSubDirectoryFactoriesPath("rionnagen mountain");
        assertEquals(expectedDirPath, actualDirPath);
    }
}