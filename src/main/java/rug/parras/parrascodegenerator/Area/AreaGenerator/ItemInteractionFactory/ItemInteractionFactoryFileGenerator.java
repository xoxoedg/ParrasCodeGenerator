package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class ItemInteractionFactoryFileGenerator implements FactoryFileGenerator {

    ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;

    @Autowired
    public ItemInteractionFactoryFileGenerator(ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator) {
        this.itemInteractionFactoryFilepathGenerator = itemInteractionFactoryFilepathGenerator;
    }
    @Override
    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(itemInteractionFactoryFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Item Interaction File already exist");
        } return validationFileResult;
    }
}

