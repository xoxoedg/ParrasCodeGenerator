package rug.parras.parrascodegenerator.AreaGenerator.WorldMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldMapDirectoryPathGeneratorService {

    WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator;

    @Autowired
    public WorldMapDirectoryPathGeneratorService(WorldMapDirectoryPathGenerator worldMapDirectoryPathGenerator) {
        this.worldMapDirectoryPathGenerator = worldMapDirectoryPathGenerator;
    }
}
