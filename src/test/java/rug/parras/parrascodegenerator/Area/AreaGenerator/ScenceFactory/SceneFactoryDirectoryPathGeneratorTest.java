package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class SceneFactoryDirectoryPathGeneratorTest {

    @Autowired
    private SceneFactoryDirectoryPathGenerator sceneFactoryDirectoryPathGenerator;

    @Test
    void createDirectoryPath() {
        String expectedDirectoryPath = "src\\test\\codeGeneratorTest\\src\\characters\\scenes\\rionnagen";
        String actualDirectoryPath = sceneFactoryDirectoryPathGenerator.createDirectoryPath("Rionnagen");
        assertEquals(expectedDirectoryPath, actualDirectoryPath);

    }

    @Test
    void createSubDirectoryConversationsPath() {
        String expectedSubDirectoryPath = "src\\test\\codeGeneratorTest\\src\\characters\\scenes\\rionnagen\\conversations";
        String actualDirectoryPath = sceneFactoryDirectoryPathGenerator.createSubDirectoryConversationsPath("Rionnagen");
        assertEquals(expectedSubDirectoryPath, actualDirectoryPath);
    }

    @Test
    void createSubDirectoryScenesPath() {
        String expectedSubDirectoryPath = "src\\test\\codeGeneratorTest\\src\\characters\\scenes\\rionnagen\\sprites";
        String actualSubDirectoryPath = sceneFactoryDirectoryPathGenerator.createSubDirectoryScenesPath("Rionnagen");
        assertEquals(expectedSubDirectoryPath, actualSubDirectoryPath);
    }
}