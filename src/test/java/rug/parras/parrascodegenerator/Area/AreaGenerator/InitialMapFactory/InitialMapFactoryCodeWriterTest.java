package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

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
class InitialMapFactoryCodeWriterTest {

    @Mock
    private InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    @Mock
    private InitialMapFactoryCodeGenerator initialMapFactoryCodeGenerator;

    @InjectMocks
    private InitialMapFactoryCodeWriter initialMapFactoryCodeWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("malaiche");
        when(initialMapFactoryFilepathGenerator.generateFilename("malaiche")).thenReturn("malaiche.py");
        when(initialMapFactoryCodeGenerator.generateFactoryCode("malaiche")).thenReturn("test");
        initialMapFactoryCodeWriter.writeToFile("malaiche");
        verify(initialMapFactoryFilepathGenerator).generateFilename("malaiche");
        verify(initialMapFactoryCodeGenerator).generateFactoryCode("malaiche");
        fileToDelete.delete();
    }

}