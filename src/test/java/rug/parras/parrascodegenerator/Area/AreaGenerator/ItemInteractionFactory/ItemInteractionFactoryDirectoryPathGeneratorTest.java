package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class ItemInteractionFactoryDirectoryPathGeneratorTest {

    @Autowired
    ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirPath = "src/test/codeGeneratorTest/src/characters/item_interaction/rionnagen_test";
        String actualDirPath = itemInteractionFactoryDirectoryPathGenerator.createDirectoryPath("Rionnagen test");
        assertEquals(expectedDirPath, actualDirPath);
    }
}