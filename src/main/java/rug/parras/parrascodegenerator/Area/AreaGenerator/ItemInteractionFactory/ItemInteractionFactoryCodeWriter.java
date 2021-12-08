package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ItemInteractionFactoryCodeWriter implements CodeWriterGenerator {

    ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    ItemInteractionFactoryCodeGenerator itemInteractionFactoryCodeGenerator;

    @Autowired
    public ItemInteractionFactoryCodeWriter(ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator, ItemInteractionFactoryCodeGenerator itemInteractionFactoryCodeGenerator) {
        this.itemInteractionFactoryFilepathGenerator = itemInteractionFactoryFilepathGenerator;
        this.itemInteractionFactoryCodeGenerator = itemInteractionFactoryCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File itemInteractionFactoryPythonFile = new File(itemInteractionFactoryFilepathGenerator.generateFilename(areaName));
        FileWriter writer = new FileWriter(itemInteractionFactoryPythonFile);
        writer.write(itemInteractionFactoryCodeGenerator.generateFactoryCode(areaName));
        writer.flush();
        writer.close();
    }
}

