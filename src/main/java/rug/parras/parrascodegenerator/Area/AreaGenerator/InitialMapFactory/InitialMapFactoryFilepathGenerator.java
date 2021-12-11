package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class InitialMapFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String INITIAL_MAP_FACTORY_FILE_TEMPLATE = "%s\\src\\worldmap\\%s\\maps\\factories\\%s_initial_map_factory.py";


    @Override
    public String generateFilename(String areaName) {
        return String.format(INITIAL_MAP_FACTORY_FILE_TEMPLATE, path, StringOperationUtils.convertSpaceToLowercase(areaName),
                StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName.toLowerCase()));
    }
}

