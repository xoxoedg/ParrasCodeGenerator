package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextMapFactoryCodeGeneratorTest {

    @Test
    void generateFactoryCode() {

        String expectedNextMapFactoryCode =
                "class MalaicheTestNextMapFactory:\n" +
                        "\n" +
                        "    @classmethod\n" +
                        "    def next_map(cls, hero):\n" +
                        "        pass";

        String actualNextMapFactoryCode = new NextMapFactoryCodeGenerator().generateFactoryCode("malaiche test");
        assertEquals(expectedNextMapFactoryCode, actualNextMapFactoryCode);
    }
}