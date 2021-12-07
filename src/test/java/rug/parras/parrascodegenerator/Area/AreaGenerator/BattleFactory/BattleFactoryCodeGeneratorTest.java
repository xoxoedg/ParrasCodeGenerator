package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleFactoryCodeGeneratorTest {

    @Test
    void generateFactoryCode() {
        BattleFactoryCodeGenerator factoryCodeGenerator = new BattleFactoryCodeGenerator();
        String expectedValue =
                "class SeannDungeonBattleFactory:\n" +
                        "\n" +
                        "    @classmethod\n" +
                        "    def create_battle(cls, hero):\n" +
                        "          pass";

        String actualValue = factoryCodeGenerator.generateFactoryCode("Seann");
        assertEquals(expectedValue, actualValue);
    }
}