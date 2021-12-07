package rug.parras.parrascodegenerator.AreaGenerator.blub.ItemInteractionFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.blub.FactoryFileGenerator;

import java.io.File;

@Component
public class ItemInteractionFactoryFileGenerator implements FactoryFileGenerator {

    private static final String ITEM_INTERACTION_FACTORY_FILE_TEMPLATE = "%s_item_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(ITEM_INTERACTION_FACTORY_FILE_TEMPLATE, areaName);
    }

    @Override
    public File createFile(String areaName) {
        return new File(generateFilename(areaName));
    }
}

