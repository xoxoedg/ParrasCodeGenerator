package rug.parras.parrascodegenerator.Area.Validation;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator.ConfigurationFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory.InitialMapFactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionFactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory.NextMapFactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.FileOperations;

import java.util.List;

@Service
public class ValidationIOService {

    BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;
    ConfigurationFilepathGenerator configurationFilepathGenerator;
    InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;
    ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator;
    MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;
    NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;
    SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;

    public ValidationIOService(BattleFactoryFilepathGenerator battleFactoryFilepathGenerator,
                               ConfigurationFilepathGenerator configurationFilepathGenerator,
                               InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator,
                               ItemInteractionFactoryFilepathGenerator itemInteractionFactoryFilepathGenerator,
                               MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator,
                               NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator,
                               SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator) {
        this.battleFactoryFilepathGenerator = battleFactoryFilepathGenerator;
        this.configurationFilepathGenerator = configurationFilepathGenerator;
        this.initialMapFactoryFilepathGenerator = initialMapFactoryFilepathGenerator;
        this.itemInteractionFactoryFilepathGenerator = itemInteractionFactoryFilepathGenerator;
        this.mapAfterInteractionFactoryFilepathGenerator = mapAfterInteractionFactoryFilepathGenerator;
        this.nextMapFactoryFilepathGenerator = nextMapFactoryFilepathGenerator;
        this.sceneFactoryFilepathGenerator = sceneFactoryFilepathGenerator;
    }


    private ValidationFileResult validateBattleFactoryFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(battleFactoryFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("BattleFactory File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }

    private ValidationFileResult validateConfigurationFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(configurationFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("Configuration File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }

    private ValidationFileResult validateInitialMapFactoryFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(initialMapFactoryFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("InitialMapFactory File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }


    private ValidationFileResult validateItemInteractionFactoryFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(itemInteractionFactoryFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("ItemInteractionFactory File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }


    private ValidationFileResult validateMapAfterInteractionFactoryFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(mapAfterInteractionFactoryFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("MapAfterInteractionFactory File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }


    private ValidationFileResult validateNextMapFactoryFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(nextMapFactoryFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("NextMapFactory File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }

    private ValidationFileResult validateSceneFactoryFile(String areaName) {
        ValidationFileResult validationFileResult = new ValidationFileResult();
        if (FileOperations.checkIfFileExist(sceneFactoryFilepathGenerator.generateFilename(areaName))) {
            validationFileResult.setValidationStatus(ValidationStatus.WARNING);
            validationFileResult.setMessage("SceneFactory File already exist");
        } else {
            validationFileResult.setValidationStatus(ValidationStatus.SUCCESS);

        }
        return validationFileResult;
    }

    public ValidationIOResult validateFiles(String areaName) {
        //Todo Refactor with stream
        ValidationIOResult validationIOResult = new ValidationIOResult();
        ValidationFileResult validationStatusBattleFactoryFileResult = validateBattleFactoryFile(areaName);
        ValidationFileResult validationStatusConfigurationFileResult = validateConfigurationFile(areaName);
        ValidationFileResult validationStatusInitialMapFactoryFileResult = validateInitialMapFactoryFile(areaName);
        ValidationFileResult validationStatusItemInteractionFactoryFileResult = validateItemInteractionFactoryFile(areaName);
        ValidationFileResult validationStatusMapAfterInteractionFactoryFileResult = validateMapAfterInteractionFactoryFile(areaName);
        ValidationFileResult validationStatusNextMapFactoryFileResult = validateNextMapFactoryFile(areaName);
        ValidationFileResult validationStatusSceneFactoryFileResult = validateSceneFactoryFile(areaName);

        List<ValidationFileResult> listFiles = List.of(validateBattleFactoryFile(areaName), validateConfigurationFile(areaName), validateInitialMapFactoryFile(areaName),
                validateItemInteractionFactoryFile(areaName), validateMapAfterInteractionFactoryFile(areaName),
                validateNextMapFactoryFile(areaName), validateSceneFactoryFile(areaName));

        listFiles.stream().filter(x -> x.getValidationStatus() == ValidationStatus.WARNING).forEach(x ->validationIOResult.getValidationFileResultsList().add(x));


        if (validationStatusBattleFactoryFileResult.getValidationStatus() == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusBattleFactoryFileResult);
        }
        if (validationStatusConfigurationFileResult.validationStatus == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusConfigurationFileResult);
        }
        if (validationStatusInitialMapFactoryFileResult.validationStatus == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusInitialMapFactoryFileResult);
        }
        if (validationStatusItemInteractionFactoryFileResult.validationStatus == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusItemInteractionFactoryFileResult);
        }
        if (validationStatusMapAfterInteractionFactoryFileResult.validationStatus == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusMapAfterInteractionFactoryFileResult);
        }
        if (validationStatusNextMapFactoryFileResult.validationStatus == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusNextMapFactoryFileResult);
        }
        if (validationStatusSceneFactoryFileResult.validationStatus == ValidationStatus.WARNING) {
            validationIOResult.getValidationFileResultsList().add(validationStatusSceneFactoryFileResult);
        }

        validationIOResult.setValidationStatus(ValidationStatus.WARNING);
        return validationIOResult;
    }
}


