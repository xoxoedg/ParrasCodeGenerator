package rug.parras.parrascodegenerator.AreaGenerator.blub.WorldMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.blub.DirectoryGenerator;

import java.io.File;

@Service
public class WorldMapDirectoryPathGeneratorService implements DirectoryGenerator {

    WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @Autowired
    public WorldMapDirectoryPathGeneratorService(WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator) {
        this.worldMapDirectoryPathGenerator = worldMapDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(worldMapDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
