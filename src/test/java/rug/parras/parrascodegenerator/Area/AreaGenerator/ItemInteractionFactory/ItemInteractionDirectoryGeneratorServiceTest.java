package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("it")
class ItemInteractionDirectoryGeneratorServiceTest {


    @Autowired
    ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService;

    @Test
    void createDirectories() {
        itemInteractionDirectoryGeneratorService.createDirectories("Wuffti");
    }
}