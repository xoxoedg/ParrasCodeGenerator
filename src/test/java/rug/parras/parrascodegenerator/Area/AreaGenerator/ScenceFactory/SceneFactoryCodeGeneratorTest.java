package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SceneFactoryCodeGeneratorTest {

    @Test
    void generateFactoryCode() {

         String expectedSceneFactoryCode =
                "class WuffOmgSceneFactory:\n" +
                        "\n" +
                        "    @classmethod\n" +
                        "    def create_scene(cls, hero):\n" +
                        "        pass";

        String actualSceneFactoryCode = new SceneFactoryCodeGenerator().generateFactoryCode("WuFf OMG");
        assertEquals(expectedSceneFactoryCode, actualSceneFactoryCode);
    }
}