package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SceneFactoryDirectoryGeneratorServiceTest {

    @Mock
    private SceneFactoryDirectoryPathGenerator sceneFactoryDirectoryPathGenerator;

    @InjectMocks
    private SceneFactoryDirectoryGeneratorService sceneFactoryDirectoryGeneratorService;

    @Test
    void createDirectories() {
        File dirToDelete = new File("wuffti");
        File subDirSceneToDelete = new File("wuffti/scence");
        File subDirConversationToDelete = new File("wuffti/conversation");
        when(sceneFactoryDirectoryPathGenerator.createDirectoryPath("wufft")).thenReturn("wuffti");
        when(sceneFactoryDirectoryPathGenerator.createSubDirectoryScenesPath("wufft")).thenReturn("wuffti/scence");
        when(sceneFactoryDirectoryPathGenerator.createSubDirectoryConversationsPath("wufft")).thenReturn("wuffti/conversation");
        sceneFactoryDirectoryGeneratorService.createDirectories("wufft");
        verify(sceneFactoryDirectoryPathGenerator).createDirectoryPath("wufft");

        subDirConversationToDelete.delete();
        subDirSceneToDelete.delete();
        dirToDelete.delete();
    }
}