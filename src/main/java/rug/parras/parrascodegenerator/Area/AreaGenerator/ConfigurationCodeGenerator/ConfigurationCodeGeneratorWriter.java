package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ConfigurationCodeGeneratorWriter implements CodeWriterGenerator {

    ConfigurationFilepathGenerator configurationFilepathGenerator;
    ConfigurationCodeGenerator configurationCodeGenerator;

    @Autowired
    public ConfigurationCodeGeneratorWriter(ConfigurationFilepathGenerator configurationFilepathGenerator, ConfigurationCodeGenerator configurationCodeGenerator) {
        this.configurationFilepathGenerator = configurationFilepathGenerator;
        this.configurationCodeGenerator = configurationCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File configurationPythonFile = new File(configurationFilepathGenerator.generateFilename(areaName));
        FileWriter writer = new FileWriter(configurationPythonFile);
        writer.write(configurationCodeGenerator.generateConfigListCode(areaName));
        writer.flush();
        writer.close();
    }
}
