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
class InitialMapFactoryFileGeneratorTest {

    @Mock
    private InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    @InjectMocks
    private InitialMapFactoryFileGenerator initialMapFactoryFileGenerator;

    @Test
    void createFile() throws IOException {
        File fileToDelete = new File("malaiche.py");
        when(initialMapFactoryFilepathGenerator.generateFilename("malaiche")).thenReturn("malaiche.py");
        initialMapFactoryFileGenerator.createFile("malaiche");
        verify(initialMapFactoryFilepathGenerator).generateFilename("malaiche");
        fileToDelete.delete();
    }
}