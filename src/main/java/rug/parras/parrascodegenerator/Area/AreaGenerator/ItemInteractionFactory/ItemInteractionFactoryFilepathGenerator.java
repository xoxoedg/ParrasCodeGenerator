package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

@Getter
@Setter
@Component
public class ItemInteractionFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String ITEM_INTERACTION_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\item_interaction\\%s\\%s_item_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(ITEM_INTERACTION_FACTORY_FILE_TEMPLATE, path, areaName.toLowerCase(), areaName.toLowerCase());
    }
}
