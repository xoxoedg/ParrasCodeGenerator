package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("it")
class GameDirectoryGeneratorServiceTest {

    @Autowired
    GameDirectoryGeneratorService gameDirectoryGeneratorService;

    @Test
    void createAllDirectories() {
        gameDirectoryGeneratorService.createAllDirectories("Rionnagen");
    }
}