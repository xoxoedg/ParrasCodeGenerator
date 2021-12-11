package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SceneFactoryCodeWriterTest {

    @Mock
    private SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;

    @Mock
    private SceneFactoryCodeGenerator sceneFactoryCodeGenerator;

    @InjectMocks
    private SceneFactoryCodeWriter sceneFactoryCodeWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("wuff.py");
        when(sceneFactoryFilepathGenerator.generateFilename("wuff")).thenReturn("wuff.py");
        when(sceneFactoryCodeGenerator.generateFactoryCode("wuff")).thenReturn("wuff");
        sceneFactoryCodeWriter.writeToFile("wuff");
        verify(sceneFactoryFilepathGenerator).generateFilename("wuff");
        verify(sceneFactoryCodeGenerator).generateFactoryCode("wuff");
        fileToDelete.delete();
    }
}