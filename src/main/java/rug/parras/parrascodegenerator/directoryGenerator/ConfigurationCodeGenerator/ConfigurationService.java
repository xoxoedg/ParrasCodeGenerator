package rug.parras.parrascodegenerator.directoryGenerator.ConfigurationCodeGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class ConfigurationService {

    public void writeToFile(String areaName) throws IOException {
        ConfigurationCodeGenerator configurationCodeGenerator = new ConfigurationCodeGenerator();
        ConfigurationFileGenerator configurationFileGenerator = new ConfigurationFileGenerator();
        FileWriter writer = new FileWriter(configurationFileGenerator.createFile());
        writer.write(configurationCodeGenerator.generateConfigListCode(areaName));
    }
}
