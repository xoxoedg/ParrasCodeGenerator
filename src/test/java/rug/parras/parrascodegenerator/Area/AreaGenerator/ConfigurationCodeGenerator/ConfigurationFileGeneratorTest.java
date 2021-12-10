package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

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
class ConfigurationFileGeneratorTest {

    @Mock
    private ConfigurationFilepathGenerator configurationFilepathGenerator;

    @InjectMocks
    private ConfigurationFileGenerator configurationFileGenerator;

    @Test
    void createFile() throws IOException {
        when(configurationFilepathGenerator.generateFilename("test")).thenReturn("test.py");
        configurationFileGenerator.createFile("test");
        verify(configurationFilepathGenerator).generateFilename("test");
        File fileToDelete = new File("test.py");
        fileToDelete.delete();
    }
}