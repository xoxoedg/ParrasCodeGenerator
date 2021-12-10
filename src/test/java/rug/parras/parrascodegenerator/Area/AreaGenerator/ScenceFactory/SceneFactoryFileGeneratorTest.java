package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SceneFactoryFileGeneratorTest {

    @Mock
    private SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;

    @InjectMocks
    private SceneFactoryFileGenerator sceneFactoryFileGenerator;

    @Test
    void createFile() throws IOException {
        File fileToDelete = new File("wuffti.py");
        when(sceneFactoryFilepathGenerator.generateFilename("WUFFTI")).thenReturn("wuffti.py");
        sceneFactoryFileGenerator.createFile("WUFFTI");
        verify(sceneFactoryFilepathGenerator).generateFilename("WUFFTI");
        fileToDelete.delete();
    }
}