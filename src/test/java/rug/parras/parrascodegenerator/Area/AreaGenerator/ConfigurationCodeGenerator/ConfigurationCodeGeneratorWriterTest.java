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
class ConfigurationCodeGeneratorWriterTest {

    @Mock
    private ConfigurationFilepathGenerator configurationFilepathGenerator;

    @Mock
    private ConfigurationCodeGenerator configurationCodeGenerator;

    @InjectMocks
    private ConfigurationCodeGeneratorWriter configurationCodeGeneratorWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("rionnagen.py");
        when(configurationFilepathGenerator.generateFilename("rionnagen")).thenReturn("rionnagen.py");
        when(configurationCodeGenerator.generateConfigListCode("rionnagen")).thenReturn("test");
        configurationCodeGeneratorWriter.writeToFile("rionnagen");
        verify(configurationCodeGenerator).generateConfigListCode("rionnagen");
        verify(configurationFilepathGenerator).generateFilename("rionnagen");
        fileToDelete.delete();
    }
}