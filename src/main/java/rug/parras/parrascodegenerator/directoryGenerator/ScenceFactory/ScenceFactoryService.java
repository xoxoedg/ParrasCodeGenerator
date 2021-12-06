package rug.parras.parrascodegenerator.directoryGenerator.ScenceFactory;

import java.io.FileWriter;
import java.io.IOException;

public class ScenceFactoryService {

    public void writeToFile(String areaName) throws IOException {
        ScenceFactoryCodeGenerator scenceFactoryCodeGenerator = new ScenceFactoryCodeGenerator();
        ScenceFactoryFileGenerator scenceFactoryFileGenerator = new ScenceFactoryFileGenerator();
        FileWriter writer = new FileWriter(scenceFactoryFileGenerator.createFile(areaName));
        writer.write(scenceFactoryCodeGenerator.generateFactoryCode(areaName));


    }
}
