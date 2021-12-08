package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class BattleFactoryCodeGeneratorWriterTest {

    @Autowired
    BattleFactoryCodeGeneratorWriter battleFactoryCodeGeneratorWriter;
    @Test
    void writeToFile() throws IOException {
        battleFactoryCodeGeneratorWriter.writeToFile("Rionnagen");
    }
}