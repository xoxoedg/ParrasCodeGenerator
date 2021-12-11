package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class BattleFactoryFilepathGeneratorTest {

    @Autowired
    private BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;

    @Test
    void generateFilename() {
        String expectedFilename = "src\\test\\codeGeneratorTest\\src\\characters\\battles\\rionnagenwuff\\rionnagen_wuff_battle_factory.py";
        String actualFilename = battleFactoryFilepathGenerator.generateFilename("Rionnagen wuff");
        assertEquals(expectedFilename, actualFilename);

    }
}