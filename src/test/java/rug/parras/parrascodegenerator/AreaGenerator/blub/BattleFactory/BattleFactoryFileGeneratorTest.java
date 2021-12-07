package rug.parras.parrascodegenerator.AreaGenerator.blub.BattleFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleFactoryFileGeneratorTest {

    @Test
    void generateFilename() {
        BattleFactoryFileGenerator fileGenerator = new BattleFactoryFileGenerator();
        String expectedValue = "rionnagen_battle_factory.py";
        String actualValue = fileGenerator.generateFilename("Rionnagen");
        assertEquals(expectedValue, actualValue);
    }
}