package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class SceneFactoryFileGenerator implements FactoryFileGenerator {

    private final SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;

    @Autowired
    public SceneFactoryFileGenerator(SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator) {
        this.sceneFactoryFilepathGenerator = sceneFactoryFilepathGenerator;
    }

    @Override
    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(sceneFactoryFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Scene Factory File already exist");
        }
        return validationFileResult;
    }
}
