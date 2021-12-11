package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class ConfigurationFileGenerator {

    private final ConfigurationFilepathGenerator configurationFilepathGenerator;

    @Autowired
    public ConfigurationFileGenerator(ConfigurationFilepathGenerator configurationFilepathGenerator) {
        this.configurationFilepathGenerator = configurationFilepathGenerator;
    }

    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(configurationFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Configuration File already exist");
        }
        return validationFileResult;
    }
}
