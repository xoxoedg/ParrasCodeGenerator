package rug.parras.parrascodegenerator.AreaGenerator.WorldMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class WorldMapDirectoryPathGeneratorService {

    WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @Autowired
    public WorldMapDirectoryPathGeneratorService(WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator) {
        this.worldMapDirectoryPathGenerator = worldMapDirectoryPathGenerator;
    }

    public void createDirectories(String areaName) {
        File directory = new File(worldMapDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
