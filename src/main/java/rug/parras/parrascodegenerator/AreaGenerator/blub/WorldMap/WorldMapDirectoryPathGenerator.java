package rug.parras.parrascodegenerator.AreaGenerator.blub.WorldMap;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.blub.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.GamePath;

@Component
public class WorldMapDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\worldmap\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, areaName);
    }

    public String createSubDirectoryMapsPath(String areaName) {
        return createDirectoryPath(areaName) + "\\maps";
    }

    public String createSubDirectorySpritesPath(String areaName) {
        return createDirectoryPath(areaName) + "\\sprites";
    }

    public String createMapSubDirectoryFactoriesPath(String areaName) {
        return createSubDirectoryMapsPath(areaName) + "\\factories";
    }
}
