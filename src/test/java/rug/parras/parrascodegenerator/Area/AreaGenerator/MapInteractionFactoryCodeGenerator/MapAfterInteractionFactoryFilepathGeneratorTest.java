package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class MapAfterInteractionFactoryFilepathGeneratorTest {

    @Autowired
    private MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    @Test
    void generateFilename() {
        String expectedMapAfterInteractionFilepath = "src\\test\\codeGeneratorTest\\src\\worldmap\\wufftes_kul\\maps\\factories\\wufftes_kul_map_after_interaction_factory.py";
        String actualMapAfterInteractionFilepath = mapAfterInteractionFactoryFilepathGenerator.generateFilename("WUFFTES kul");
        System.out.println(actualMapAfterInteractionFilepath);
        assertEquals(expectedMapAfterInteractionFilepath, actualMapAfterInteractionFilepath);

    }
}