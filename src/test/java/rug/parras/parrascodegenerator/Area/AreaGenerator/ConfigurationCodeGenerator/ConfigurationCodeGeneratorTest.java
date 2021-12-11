package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConfigurationCodeGeneratorTest {

    @Autowired
    private ConfigurationCodeGenerator configurationCodeGenerator;

    @Test
    void generateConfigListCode() {
        String expectedCode = "ALL_RIONNAGEN_MAPS=[]";
        String actualCode = configurationCodeGenerator.generateConfigListCode("Rionnagen");
        assertEquals(expectedCode, actualCode);
    }
}