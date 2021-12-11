package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator.ConfigurationFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory.InitialMapFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory.NextMapFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileGenerationServiceTest {

    @Mock
    private BattleFactoryFileGenerator battleFactoryFileGenerator;

    @Mock
    private ConfigurationFileGenerator configurationFileGenerator;


    @Mock
    private InitialMapFactoryFileGenerator initialMapFactoryFileGenerator;

    @Mock
    private ItemInteractionFactoryFileGenerator itemInteractionFactoryFileGenerator;

    @Mock
    private MapAfterInteractionFactoryFileGenerator mapAfterInteractionFactoryFileGenerator;

    @Mock
    private NextMapFactoryFileGenerator nextMapFactoryFileGenerator;

    @Mock
    private SceneFactoryFileGenerator sceneFactoryFileGenerator;

    @InjectMocks
    private FileGenerationService fileGenerationService;


    @Test
    void createFiles() throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        when(battleFactoryFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        when(configurationFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        when(initialMapFactoryFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        when(itemInteractionFactoryFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        when(mapAfterInteractionFactoryFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        when(nextMapFactoryFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        when(sceneFactoryFileGenerator.createFile("rionnagen")).thenReturn(validationFileResult);
        fileGenerationService.createFiles("rionnagen");
        verify(battleFactoryFileGenerator).createFile("rionnagen");
        verify(configurationFileGenerator).createFile("rionnagen");
        verify(initialMapFactoryFileGenerator).createFile("rionnagen");
        verify(itemInteractionFactoryFileGenerator).createFile("rionnagen");
        verify(mapAfterInteractionFactoryFileGenerator).createFile("rionnagen");
        verify(nextMapFactoryFileGenerator).createFile("rionnagen");
        verify(sceneFactoryFileGenerator).createFile("rionnagen");
    }


}