package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class ItemInteractionFactoryFileGenerator implements FactoryFileGenerator {

    ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    @Autowired
    public ItemInteractionFactoryFileGenerator(ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator) {
        this.itemInteractionFactoryFilepathGenerator = itemInteractionFactoryFilepathGenerator;
    }
    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(itemInteractionFactoryFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}

