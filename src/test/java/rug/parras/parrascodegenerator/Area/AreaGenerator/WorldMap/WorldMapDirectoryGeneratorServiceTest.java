package rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorldMapDirectoryGeneratorServiceTest {

    @Mock
    private WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @InjectMocks
    private WorldMapDirectoryGeneratorService worldMapDirectoryGeneratorService;

    @Test
    void createDirectories() {
        File dirToDelete = new File("wuffti");
        File subDirMapsToDelete = new File("wuffti/maps");
        File subDirSpritesToDelete = new File("wuffti/sprites");
        File subDirMapsFactoriesToDelete = new File("wuffti/maps/factories");
        when(worldMapDirectoryPathGenerator.createDirectoryPath("wuffti")).thenReturn("wuffti");
        when(worldMapDirectoryPathGenerator.createSubDirectoryMapsPath("wuffti")).thenReturn("wuffti/maps");
        when(worldMapDirectoryPathGenerator.createSubDirectorySpritesPath("wuffti")).thenReturn("wuffti/sprites");
        when(worldMapDirectoryPathGenerator.createMapSubDirectoryFactoriesPath("wuffti")).thenReturn("wuffti/maps/factories");
        worldMapDirectoryGeneratorService.createDirectories("wuffti");
        verify(worldMapDirectoryPathGenerator).createDirectoryPath("wuffti");

        subDirMapsFactoriesToDelete.delete();
        subDirSpritesToDelete.delete();
        subDirMapsToDelete.delete();
        dirToDelete.delete();
    }
}