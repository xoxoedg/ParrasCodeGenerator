package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class MapAfterInteractionFactoryFilepathGeneratorTest {

    @Autowired
    MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    @Test
    void generateFilename() {
       String expectedMapAfterInteractionFilepath = "src\\test\\codeGeneratorTest\\src\\worldmap\\wufftes\\maps\\factories\\wufftes_map_after_interaction_factory.py";
       String actualMapAfterInteractionFilepath = mapAfterInteractionFactoryFilepathGenerator.generateFilename("wufftes");
       System.out.println(actualMapAfterInteractionFilepath);
       assertEquals(expectedMapAfterInteractionFilepath, actualMapAfterInteractionFilepath);

    }
}