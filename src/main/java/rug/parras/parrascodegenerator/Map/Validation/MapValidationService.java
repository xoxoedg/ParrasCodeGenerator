package rug.parras.parrascodegenerator.Map.Validation;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Map.Map;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.util.List;

@Service
public class MapValidationService {

    private ValidationFieldResult validateMapInput(String mapName) {
        ValidationFieldResult validationFieldResult = new ValidationFieldResult();
        boolean validMapName = mapName.matches("^[a-zA-Z]+((_[a-zA-Z]+)+)?");
        if (validMapName) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Map Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Map Input: Only lowercase letters and separated by an _ and has to end with 'map'");
        } return validationFieldResult;
    }

    private ValidationFieldResult validateFilenameInput(String filename) {
        ValidationFieldResult validationFieldResult = new ValidationFieldResult();
        boolean validFilename = filename.matches("[a-zA-z]+((_[a-zA-z])+)?\\.py");
        if (validFilename) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Filename Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Filename Input: Must be Lowercase letter and end with a .py");
        }
        return validationFieldResult;
    }

    private ValidationFieldResult validateCoordinates(String x,String y) {
        List<String> validCoordinates = List.of("LEFT_EDGE", "RIGHT_EDGE", "BOTTOM", "TOP");
        ValidationFieldResult validationFieldResult = new ValidationFieldResult();
        boolean validCoordinateInput = ((x.matches("-?[0-9]+") || validCoordinates.contains(x.toUpperCase()))) &&
                ((y.matches("-?[0-9]+") || validCoordinates.contains(y.toUpperCase())));
        if (validCoordinateInput) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Coordinate Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Coordinate Input: Coordinate must be an Integer");
        } return validationFieldResult;

    }

    public ValidationResult validateInput(Map map) {
        ValidationResult validationResult = new ValidationResult();
        ValidationFieldResult validateMapInputResult = validateMapInput(map.getMapName());
        ValidationFieldResult validationFilenameResult = validateFilenameInput(map.getFilename().toLowerCase());
        ValidationFieldResult validationCoordinatesResult = validateCoordinates(map.getXCoordinate(), map.getYCoordinate());
        if (validateMapInputResult.getValidationStatus() == ValidationStatus.ERROR) {
            validationResult.getValidationFieldResultList().add(validateMapInputResult);
        }
        if (validationFilenameResult.getValidationStatus() == ValidationStatus.ERROR) {
            validationResult.getValidationFieldResultList().add(validationFilenameResult);
        }
        if (validationCoordinatesResult.getValidationStatus() == ValidationStatus.ERROR) {
            validationResult.getValidationFieldResultList().add(validationCoordinatesResult);
        }
        if (validationResult.getValidationFieldResultList().size() > 0) {
            validationResult.setValidationStatus(ValidationStatus.ERROR);
        } else {
            validationResult.setValidationStatus(ValidationStatus.SUCCESS);
        } return validationResult;
    }
}

