package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("it")
class SceneFactoryFilepathGeneratorTest {

    @Autowired
    private SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;

    @Test
    void generateFilename() {

        String expectedSceneFactoryFilepath = "src\\test\\codeGeneratorTest\\src\\characters\\scenes\\rionnagen_top\\rionnagen_top_scene_factory.py";
        String actualSceneFactoryFilepath = sceneFactoryFilepathGenerator.generateFilename("RIONNAGEN TOp");
        assertEquals(expectedSceneFactoryFilepath, actualSceneFactoryFilepath);
    }
}