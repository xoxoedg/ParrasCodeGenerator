package rug.parras.parrascodegenerator.AreaGenerator.blub.ConfigurationCodeGenerator;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class ConfigurationService {

    public void writeToFile(String areaName) throws IOException {
        ConfigurationCodeGenerator configurationCodeGenerator = new ConfigurationCodeGenerator();
        ConfigurationFileGenerator configurationFileGenerator = new ConfigurationFileGenerator();
        FileWriter writer = new FileWriter(configurationFileGenerator.createFile());
        writer.write(configurationCodeGenerator.generateConfigListCode(areaName));
    }
}
