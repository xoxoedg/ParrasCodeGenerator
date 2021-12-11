package rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class WorldMapDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private static final String PARRAS_DIRECTIORY_PATH = "%s\\src\\worldmap\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, StringOperationUtils.convertSpaceToLowercase(areaName));
    }

    public String createSubDirectoryMapsPath(String areaName) {
        return createDirectoryPath(StringOperationUtils.convertSpaceToLowercase(areaName)) + "\\maps";
    }

    public String createSubDirectorySpritesPath(String areaName) {
        return createDirectoryPath(StringOperationUtils.convertSpaceToLowercase(areaName)) + "\\sprites";
    }

    public String createMapSubDirectoryFactoriesPath(String areaName) {
        return createSubDirectoryMapsPath(StringOperationUtils.convertSpaceToLowercase(areaName)) + "\\factories";
    }
}
