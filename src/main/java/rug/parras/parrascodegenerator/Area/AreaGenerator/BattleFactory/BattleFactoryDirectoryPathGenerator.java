package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class BattleFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private static final String PARRAS_DIRECTIORY_PATH = "%s/src/characters/battles/%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}

