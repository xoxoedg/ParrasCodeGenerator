package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class InitialMapFactoryFilepathGeneratorTest {

    @Autowired
    private InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    @Test
    void generateFilename() {
        String expectedFilepath = "src\\test\\codeGeneratorTest\\src\\worldmap\\rionnagen\\maps\\factories\\rionnagen_initial_map_factory.py";
        String actualFilepath = initialMapFactoryFilepathGenerator.generateFilename("Rionnagen");
        assertEquals(expectedFilepath, actualFilepath);
    }
}