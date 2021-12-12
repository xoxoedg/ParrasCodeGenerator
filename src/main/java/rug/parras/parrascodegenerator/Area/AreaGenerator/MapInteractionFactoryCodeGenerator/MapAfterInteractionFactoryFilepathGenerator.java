package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class MapAfterInteractionFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String MAP_AFTER_INTERACTION_FACTORY_FILE_GENERATOR = "%s\\src\\worldmap\\%s\\maps\\factories\\%s_map_after_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(MAP_AFTER_INTERACTION_FACTORY_FILE_GENERATOR, path, StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName),
                StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}
