package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryCodeGeneratorWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator.ConfigurationCodeGeneratorWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory.InitialMapFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory.NextMapFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryCodeWriter;

import java.io.IOException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CodeWriterServiceTest {

    @Mock
    private BattleFactoryCodeGeneratorWriter battleFactoryCodeGeneratorWriter;

    @Mock
    private ConfigurationCodeGeneratorWriter configurationCodeGeneratorWriter;

    @Mock
    private InitialMapFactoryCodeWriter initialMapFactoryCodeWriter;

    @Mock
    private ItemInteractionFactoryCodeWriter itemInteractionFactoryCodeWriter;

    @Mock
    private MapAfterInteractionFactoryCodeWriter mapAfterInteractionFactoryCodeWriter;

    @Mock
    private NextMapFactoryCodeWriter nextMapFactoryCodeWriter;

    @Mock
    private SceneFactoryCodeWriter sceneFactoryCodeWriter;

    @InjectMocks
    private CodeWriterService codeWriterService;

    @Test
    void writeCodeToFile() throws IOException {
        doNothing().when(battleFactoryCodeGeneratorWriter).writeToFile("rionnagen");
        doNothing().when(configurationCodeGeneratorWriter).writeToFile("rionnagen");
        doNothing().when(initialMapFactoryCodeWriter).writeToFile("rionnagen");
        doNothing().when(itemInteractionFactoryCodeWriter).writeToFile("rionnagen");
        doNothing().when(mapAfterInteractionFactoryCodeWriter).writeToFile("rionnagen");
        doNothing().when(nextMapFactoryCodeWriter).writeToFile("rionnagen");
        doNothing().when(sceneFactoryCodeWriter).writeToFile("rionnagen");
        codeWriterService.writeCodeToFile("rionnagen");
        verify(battleFactoryCodeGeneratorWriter).writeToFile("rionnagen");
        verify(configurationCodeGeneratorWriter).writeToFile("rionnagen");
        verify(initialMapFactoryCodeWriter).writeToFile("rionnagen");
        verify(itemInteractionFactoryCodeWriter).writeToFile("rionnagen");
        verify(mapAfterInteractionFactoryCodeWriter).writeToFile("rionnagen");
        verify(nextMapFactoryCodeWriter).writeToFile("rionnagen");
        verify(sceneFactoryCodeWriter).writeToFile("rionnagen");
    }
}