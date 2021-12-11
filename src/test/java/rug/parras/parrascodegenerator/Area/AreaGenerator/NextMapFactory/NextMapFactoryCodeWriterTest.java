package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

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
class NextMapFactoryCodeWriterTest {

    @Mock
    private NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;

    @Mock
    private NextMapFactoryCodeGenerator nextMapFactoryCodeGenerator;

    @InjectMocks
    private NextMapFactoryCodeWriter nextMapFactoryCodeWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("wufftest.py");
        when(nextMapFactoryFilepathGenerator.generateFilename("wufftest")).thenReturn("wufftest.py");
        when(nextMapFactoryCodeGenerator.generateFactoryCode("wufftest")).thenReturn("test");
        nextMapFactoryCodeWriter.writeToFile("wufftest");
        verify(nextMapFactoryFilepathGenerator).generateFilename("wufftest");
        verify(nextMapFactoryCodeGenerator).generateFactoryCode("wufftest");
        fileToDelete.delete();
    }
}