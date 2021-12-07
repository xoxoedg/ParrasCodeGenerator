package rug.parras.parrascodegenerator.AreaGenerator.blub.NextMapFactory;

import java.io.FileWriter;
import java.io.IOException;

public class NextMapFactoryService {

    public void writeToFile(String areaName) throws IOException {
        NextMapFactoryCodeGenerator nextMapFactoryCodeGenerator = new NextMapFactoryCodeGenerator();
        NextMapFactoryFileGenerator nextMapFactoryFileGenerator = new NextMapFactoryFileGenerator();
        FileWriter writer = new FileWriter(nextMapFactoryFileGenerator.generateFilename(areaName));
        writer.write(nextMapFactoryCodeGenerator.generateFactoryCode(areaName));
    }
}
