package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Component
public class ItemInteractionFactoryCodeWriter implements CodeWriterGenerator {

    private final ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    private final ItemInteractionFactoryCodeGenerator itemInteractionFactoryCodeGenerator;

    @Autowired
    public ItemInteractionFactoryCodeWriter(ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator, ItemInteractionFactoryCodeGenerator itemInteractionFactoryCodeGenerator) {
        this.itemInteractionFactoryFilepathGenerator = itemInteractionFactoryFilepathGenerator;
        this.itemInteractionFactoryCodeGenerator = itemInteractionFactoryCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File itemInteractionFactoryPythonFile = new File(itemInteractionFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperationsUtils.checkIfFileIsEmpty(itemInteractionFactoryPythonFile)) {
            FileOperationsUtils.writeToFile(itemInteractionFactoryCodeGenerator.generateFactoryCode(areaName), itemInteractionFactoryPythonFile);
        }
    }
}

