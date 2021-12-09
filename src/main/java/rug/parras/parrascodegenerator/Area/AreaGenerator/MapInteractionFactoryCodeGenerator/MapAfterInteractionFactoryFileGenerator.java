package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class MapAfterInteractionFactoryFileGenerator implements FactoryFileGenerator {

    MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    @Autowired
    public MapAfterInteractionFactoryFileGenerator(MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator) {
        this.mapAfterInteractionFactoryFilepathGenerator = mapAfterInteractionFactoryFilepathGenerator;
    }

    @Override
    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(mapAfterInteractionFactoryFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Map After Interaction Factory File already exists");
        } return validationFileResult;
    }
}
