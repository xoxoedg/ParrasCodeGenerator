package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemInteractionFactoryFileGeneratorTest {

    @Mock
    ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    @InjectMocks
    ItemInteractionFactoryFileGenerator itemInteractionFactoryFileGenerator;


    @Test
    void createFile() throws IOException {
        File fileToDelete = new File("test.py");
        when(itemInteractionFactoryFilepathGenerator.generateFilename("test"))
                .thenReturn("test.py");
        itemInteractionFactoryFileGenerator.createFile("test");
        verify(itemInteractionFactoryFilepathGenerator).generateFilename("test");
        fileToDelete.delete();
    }
}