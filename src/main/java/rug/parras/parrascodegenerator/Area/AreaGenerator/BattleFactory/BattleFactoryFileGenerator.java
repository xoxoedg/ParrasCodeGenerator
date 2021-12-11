package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Component
public class BattleFactoryFileGenerator implements FactoryFileGenerator {

    private final BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;

    @Autowired
    public BattleFactoryFileGenerator(BattleFactoryFilepathGenerator battleFactoryFilepathGenerator) {
        this.battleFactoryFilepathGenerator = battleFactoryFilepathGenerator;
    }

    @Override
    public ValidationFileResult createFile(String areaName) throws IOException {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (new File(battleFactoryFilepathGenerator.generateFilename(areaName)).createNewFile()) {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Battle Factory File already exist");
        }
        return validationFileResult;
    }
}
