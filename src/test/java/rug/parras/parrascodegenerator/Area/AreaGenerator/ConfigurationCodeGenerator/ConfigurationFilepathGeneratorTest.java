package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class ConfigurationFilepathGeneratorTest {

    @Autowired
    private ConfigurationFilepathGenerator configurationFilepathGenerator;


    @Test
    void generateFilename() {
        String expectedFilepath = "src/test/codeGeneratorTest/src/worldmap/deadgead_mountain/configuration.py";
        String actualFilepath = configurationFilepathGenerator.generateFilename("DeadGead Mountain");
        assertEquals(expectedFilepath, actualFilepath);
    }
}
