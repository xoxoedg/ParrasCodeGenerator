package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class NextMapFactoryFilepathGeneratorTest {

    @Autowired
    private NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;

    @Test
    void generateFilename() {

        String expectedFilepath = "src/test/codeGeneratorTest/src/worldmap/wuff/maps/factories/wuff_next_map_factory.py";
        String actualFilepath = nextMapFactoryFilepathGenerator.generateFilename("WUFF");
        assertEquals(expectedFilepath, actualFilepath);
    }
}