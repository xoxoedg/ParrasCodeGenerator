package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryCodeGeneratorWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator.ConfigurationCodeGeneratorWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory.InitialMapFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory.NextMapFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryCodeWriter;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.when;

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

    }
}