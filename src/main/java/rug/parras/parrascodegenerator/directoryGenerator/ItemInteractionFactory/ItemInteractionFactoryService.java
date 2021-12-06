package rug.parras.parrascodegenerator.directoryGenerator.ItemInteractionFactory;

import java.io.FileWriter;
import java.io.IOException;

public class ItemInteractionFactoryService {

    public void writeToFile(String areaName) throws IOException {
        ItemInteractionFactoryCodeGeneration itemInteractionFactoryCodeGeneration = new ItemInteractionFactoryCodeGeneration();
        ItemInteractionFactoryFileGenerator itemInteractionFactoryFileGenerator = new ItemInteractionFactoryFileGenerator();
        FileWriter writer = new FileWriter(itemInteractionFactoryFileGenerator.createFile(areaName));
        writer.write(itemInteractionFactoryCodeGeneration.generateFactoryCode(areaName));
    }
}
