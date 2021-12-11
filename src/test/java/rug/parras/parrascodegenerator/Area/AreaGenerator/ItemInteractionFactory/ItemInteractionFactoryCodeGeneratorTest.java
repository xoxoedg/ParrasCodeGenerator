package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemInteractionFactoryCodeGeneratorTest {

    @Test
    void generateFactoryCode() {
        String expectedItemInteractionFactoryCode =
                "class DeadgeadMountainItemInteractionFactory:\n" +
                        "\n" +
                        "    @classmethod\n" +
                        "    def create_interaction(cls, hero):\n" +
                        "        pass";

        String actualItemInteractionFactoryCode = new ItemInteractionFactoryCodeGenerator().generateFactoryCode("deadgead mountain");
        assertEquals(expectedItemInteractionFactoryCode, actualItemInteractionFactoryCode);
    }
}