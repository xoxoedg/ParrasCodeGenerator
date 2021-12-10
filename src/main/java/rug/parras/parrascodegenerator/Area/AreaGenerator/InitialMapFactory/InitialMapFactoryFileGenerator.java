package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class InitialMapFactoryFileGenerator implements FactoryFileGenerator {

    InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    @Autowired
    public InitialMapFactoryFileGenerator(InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator) {
        this.initialMapFactoryFilepathGenerator = initialMapFactoryFilepathGenerator;
    }

    @Override
    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(initialMapFactoryFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Initial Map Factory File already exists");
        }
        return validationFileResult;
    }
}
