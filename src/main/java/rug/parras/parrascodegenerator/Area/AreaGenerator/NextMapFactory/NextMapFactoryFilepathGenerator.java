package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class NextMapFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String NEXT_MAP_FACTORY_FILE_TEMPLATE = "%s\\src\\worldmap\\%s\\maps\\factories\\%s_next_map_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(NEXT_MAP_FACTORY_FILE_TEMPLATE, path, StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName),
                StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}
