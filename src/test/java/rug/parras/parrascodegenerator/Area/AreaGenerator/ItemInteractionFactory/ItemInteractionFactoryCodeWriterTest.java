package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

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
class ItemInteractionFactoryCodeWriterTest {

    @Mock
    private ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    @Mock
    private ItemInteractionFactoryCodeGenerator itemInteractionFactoryCodeGenerator;

    @InjectMocks
    private ItemInteractionFactoryCodeWriter itemInteractionFactoryCodeWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("oha.py");
        when(itemInteractionFactoryFilepathGenerator.generateFilename("oha")).thenReturn("oha.py");
        when(itemInteractionFactoryCodeGenerator.generateFactoryCode("oha")).thenReturn("test");
        itemInteractionFactoryCodeWriter.writeToFile("oha");
        verify(itemInteractionFactoryFilepathGenerator).generateFilename("oha");
        verify(itemInteractionFactoryCodeGenerator).generateFactoryCode("oha");
        fileToDelete.delete();
    }

}