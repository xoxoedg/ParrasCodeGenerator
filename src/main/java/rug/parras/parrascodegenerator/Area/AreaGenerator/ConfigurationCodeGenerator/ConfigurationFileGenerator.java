package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ConfigurationFileGenerator {

    ConfigurationFilepathGenerator configurationFilepathGenerator;

    @Autowired
    public ConfigurationFileGenerator(ConfigurationFilepathGenerator configurationFilepathGenerator) {
        this.configurationFilepathGenerator = configurationFilepathGenerator;
    }

    public boolean createFile(String areaName) throws IOException {
        return new File(configurationFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}
