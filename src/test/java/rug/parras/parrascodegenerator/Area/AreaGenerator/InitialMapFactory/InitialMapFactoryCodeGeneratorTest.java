package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitialMapFactoryCodeGeneratorTest {

    @Test
    void generateFactoryCode() {
        InitialMapFactoryCodeGenerator initialMapFactoryCodeGenerator = new InitialMapFactoryCodeGenerator();
        String expectedInitialMapFactoryClass =
                "class RionnagenInitialMapFactory:\n" +
                        "\n" +
                        "    @classmethod\n" +
                        "    def initial_map(cls, current_map):\n" +
                        "        pass";

        String actualInitialMapFactoryClass = initialMapFactoryCodeGenerator.generateFactoryCode("Rionnagen");
        assertEquals(expectedInitialMapFactoryClass, actualInitialMapFactoryClass);
    }
}