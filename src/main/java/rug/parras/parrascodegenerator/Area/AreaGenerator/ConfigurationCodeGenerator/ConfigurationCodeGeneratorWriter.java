package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Component
public class ConfigurationCodeGeneratorWriter implements CodeWriterGenerator {

    private final ConfigurationFilepathGenerator configurationFilepathGenerator;
    private final ConfigurationCodeGenerator configurationCodeGenerator;

    @Autowired
    public ConfigurationCodeGeneratorWriter(ConfigurationFilepathGenerator configurationFilepathGenerator, ConfigurationCodeGenerator configurationCodeGenerator) {
        this.configurationFilepathGenerator = configurationFilepathGenerator;
        this.configurationCodeGenerator = configurationCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File configurationPythonFile = new File(configurationFilepathGenerator.generateFilename(areaName));
        if (FileOperationsUtils.checkIfFileIsEmpty(configurationPythonFile)) {
            FileOperationsUtils.writeToFile(configurationCodeGenerator.generateConfigListCode(areaName), configurationPythonFile);
        }
    }
}
