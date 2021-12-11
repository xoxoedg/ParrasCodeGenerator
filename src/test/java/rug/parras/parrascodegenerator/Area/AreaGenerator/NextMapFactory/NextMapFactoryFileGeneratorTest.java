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
class NextMapFactoryFileGeneratorTest {

    @Mock
    private NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;

    @InjectMocks
    private NextMapFactoryFileGenerator nextMapFactoryFileGenerator;

    @Test
    void createFile() throws IOException {
        File fileToDelete = new File("testarea.py");
        when(nextMapFactoryFilepathGenerator.generateFilename("testarea")).thenReturn("testarea.py");
        nextMapFactoryFileGenerator.createFile("testarea");
        verify(nextMapFactoryFilepathGenerator).generateFilename("testarea");
        fileToDelete.delete();
    }
}