package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

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
class MapAfterInteractionFactoryCodeWriterTest {

    @Mock
    private MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    @Mock
    private MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator;

    @InjectMocks
    private MapAfterInteractionFactoryCodeWriter mapAfterInteractionFactoryCodeWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("pom.py");
        when(mapAfterInteractionFactoryFilepathGenerator.generateFilename("pom"))
                .thenReturn("pom.py");
        when(mapAfterInteractionFactoryCodeGenerator.generateFactoryCode("pom"))
                .thenReturn("test");
        mapAfterInteractionFactoryCodeWriter.writeToFile("pom");
        verify(mapAfterInteractionFactoryFilepathGenerator).generateFilename("pom");
        verify(mapAfterInteractionFactoryCodeGenerator).generateFactoryCode("pom");
        fileToDelete.delete();

    }
}