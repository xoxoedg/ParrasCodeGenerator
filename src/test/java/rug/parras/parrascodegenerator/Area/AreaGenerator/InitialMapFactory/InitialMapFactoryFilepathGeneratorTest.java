package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class InitialMapFactoryFilepathGeneratorTest {

    @Autowired
    private InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    @Test
    void generateFilename() {
        String expectedFilepath = "src\\test\\codeGeneratorTest\\src\\worldmap\\testwufffactory\\maps\\factories\\test_wuff_factory_initial_map_factory.py";
        String actualFilepath = initialMapFactoryFilepathGenerator.generateFilename("teSt wuff factory");
        assertEquals(expectedFilepath, actualFilepath);
    }
}