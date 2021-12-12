package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class ItemInteractionFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private final static String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\item_interaction\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}
