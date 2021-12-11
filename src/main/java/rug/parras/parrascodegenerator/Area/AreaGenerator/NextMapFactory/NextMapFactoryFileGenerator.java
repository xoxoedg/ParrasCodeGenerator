package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class NextMapFactoryFileGenerator implements FactoryFileGenerator {

    private final NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;

    @Autowired
    public NextMapFactoryFileGenerator(NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator) {
        this.nextMapFactoryFilepathGenerator = nextMapFactoryFilepathGenerator;
    }


    @Override
    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(nextMapFactoryFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Next Map Factory already exist");
        }
        return validationFileResult;
    }
}
