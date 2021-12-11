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
class MapAfterInteractionFactoryFileGeneratorTest {

    @Mock
    private MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    @InjectMocks
    private MapAfterInteractionFactoryFileGenerator mapAfterInteractionFactoryFileGenerator;

    @Test
    void createFile() throws IOException {
        File fileToDelete = new File("pom.py");
        when(mapAfterInteractionFactoryFilepathGenerator.generateFilename("pom"))
                .thenReturn("pom.py");
        mapAfterInteractionFactoryFileGenerator.createFile("pom");
        verify(mapAfterInteractionFactoryFilepathGenerator).generateFilename("pom");
        fileToDelete.delete();
    }
}