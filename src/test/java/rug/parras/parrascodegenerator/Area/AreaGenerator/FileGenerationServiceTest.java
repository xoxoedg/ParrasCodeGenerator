package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class FileGenerationServiceTest {

    @Autowired
    FileGenerationService fileGenerationService;


    @Test
    void createFiles() throws IOException {
        fileGenerationService.createFiles("Seann");
    }
}