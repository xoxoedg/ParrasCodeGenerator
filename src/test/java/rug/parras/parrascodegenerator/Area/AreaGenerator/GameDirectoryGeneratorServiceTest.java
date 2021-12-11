package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap.WorldMapDirectoryGeneratorService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameDirectoryGeneratorServiceTest {

    @Mock
    private BattleFactoryDirectoryGeneratorService battleFactoryDirectoryGeneratorService;

    @Mock
    private ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService;

    @Mock
    private SceneFactoryDirectoryGeneratorService sceneFactoryDirectoryGeneratorService;

    @Mock
    private WorldMapDirectoryGeneratorService worldMapDirectoryPathGeneratorService;

    @InjectMocks
    private GameDirectoryGeneratorService gameDirectoryGeneratorService;

    @Test
    void createAllDirectories() {
        doNothing().when(battleFactoryDirectoryGeneratorService).createDirectories("rionnagen");
        doNothing().when(itemInteractionDirectoryGeneratorService).createDirectories("rionnagen");
        doNothing().when(sceneFactoryDirectoryGeneratorService).createDirectories("rionnagen");
        doNothing().when(worldMapDirectoryPathGeneratorService).createDirectories("rionnagen");
        gameDirectoryGeneratorService.createAllDirectories("rionnagen");
        verify(battleFactoryDirectoryGeneratorService).createDirectories("rionnagen");
        verify(itemInteractionDirectoryGeneratorService).createDirectories("rionnagen");
        verify(sceneFactoryDirectoryGeneratorService).createDirectories("rionnagen");
        verify(worldMapDirectoryPathGeneratorService).createDirectories("rionnagen");
    }
}