package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class ItemInteractionFactoryFilepathGeneratorTest {

    @Autowired
    private ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    @Test
    void generateFilename() {
        String expectedFilename = "src\\test\\codeGeneratorTest\\src\\characters\\item_interaction\\malaichehills\\malaiche_hills_item_interaction_factory.py";
        String actualFilename = itemInteractionFactoryFilepathGenerator.generateFilename("malaiche hills");
        assertEquals(expectedFilename, actualFilename);
    }
}