package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemInteractionDirectoryGeneratorServiceTest {

    @Mock
    private ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator;


    @InjectMocks
    private ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService;

    @Test
    void createDirectories() {
        File dirToDelete = new File("wuffl");
        when(itemInteractionFactoryDirectoryPathGenerator.createDirectoryPath("wuffl"))
                .thenReturn("wuffl");
        itemInteractionDirectoryGeneratorService.createDirectories("wuffl");
        verify(itemInteractionFactoryDirectoryPathGenerator).createDirectoryPath("wuffl");
        dirToDelete.delete();
    }
}