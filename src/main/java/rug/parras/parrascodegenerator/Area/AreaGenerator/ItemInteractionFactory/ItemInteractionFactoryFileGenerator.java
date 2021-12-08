package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class ItemInteractionFactoryFileGenerator extends GamePath implements FactoryFileGenerator {

    private static final String ITEM_INTERACTION_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\item_interaction\\%s\\%s_item_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(ITEM_INTERACTION_FACTORY_FILE_TEMPLATE, path,areaName, areaName);
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(generateFilename(areaName)).createNewFile();
    }
}

