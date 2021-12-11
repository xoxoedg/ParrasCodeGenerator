package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;


@Component
public class ItemInteractionFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String ITEM_INTERACTION_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\item_interaction\\%s\\%s_item_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(ITEM_INTERACTION_FACTORY_FILE_TEMPLATE, path, StringOperationUtils.convertSpaceToLowercase(areaName),
                StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}
