package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConfigurationCodeGeneratorTest {

    @Autowired
    ConfigurationCodeGenerator configurationCodeGenerator;

    @Test
    void generateConfigListCode() {
        String expectedCode = "ALL_RIONNAGEN_MAPS=[]";
        String actualCode = configurationCodeGenerator.generateConfigListCode("Rionnagen");
        assertEquals(expectedCode, actualCode);
    }
}