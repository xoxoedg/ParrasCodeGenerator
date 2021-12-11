package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapAfterInteractionFactoryCodeGeneratorTest {

    @Test
    void generateFactoryCode() {

        String expectedMapAfterInteractionFactoryClass =
                "class DeadMountainMapAfterInteractionFactory:\n" +
                        "\n" +
                        "    @classmethod\n" +
                        "    def change_map_on_interaction(cls, after, hero):\n" +
                        "        pass";
        String actualMapAfterInteractionFactoryClass = new MapAfterInteractionFactoryCodeGenerator().generateFactoryCode("dead mountain");
        assertEquals(expectedMapAfterInteractionFactoryClass, actualMapAfterInteractionFactoryClass);
    }
}