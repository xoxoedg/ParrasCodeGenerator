package rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryGenerator;

import java.io.File;

@Service
public class WorldMapDirectoryGeneratorService implements DirectoryGenerator {

    private final WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @Autowired
    public WorldMapDirectoryGeneratorService(WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator) {
        this.worldMapDirectoryPathGenerator = worldMapDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(worldMapDirectoryPathGenerator.createDirectoryPath(areaName));
        File subMapDirectory = new File(worldMapDirectoryPathGenerator.createSubDirectoryMapsPath(areaName));
        File subSpritesDirectory = new File(worldMapDirectoryPathGenerator.createSubDirectorySpritesPath(areaName));
        File subMapFactoriesDirectory = new File(worldMapDirectoryPathGenerator.createMapSubDirectoryFactoriesPath(areaName));
        directory.mkdirs();
        subMapDirectory.mkdirs();
        subSpritesDirectory.mkdirs();
        subMapFactoriesDirectory.mkdirs();
    }
}
