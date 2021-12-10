package rug.parras.parrascodegenerator.Map.Validation;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Map.Map;

@Service
public class MapValidationService {

    private ValidationFieldResult validateMapInput(String mapName) {
        ValidationFieldResult validationFieldResult = new ValidationFieldResult();
        boolean validMapName = mapName.matches("^[a-z]+((_[a-z]+)+)+_map");
        if (validMapName) {
            validationFieldResult.setValidationStatus(MapValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Map Input");
        } else {
            validationFieldResult.setValidationStatus(MapValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Map Input: Only lowercase letters and separated by an _ and has to end with 'map'");
        } return validationFieldResult;
    }

    private ValidationFieldResult validateFilenameInput(String filename) {
        ValidationFieldResult validationFieldResult = new ValidationFieldResult();
        boolean validFilename = filename.matches("[a-z]+\\.py");
        if (validFilename) {
            validationFieldResult.setValidationStatus(MapValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Filename Input");
        } else {
            validationFieldResult.setValidationStatus(MapValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Filename Input: Must be Lowercase letter and end with a .py");
        }
        return validationFieldResult;
    }

    private ValidationFieldResult validateCoordinates(int x, int y) {
        ValidationFieldResult validationFieldResult = new ValidationFieldResult();
        boolean validCoordinateInput = String.valueOf(x).matches("-?[0-9]+") && String.valueOf(y).matches("-?[0-9]+");
        if (validCoordinateInput) {
            validationFieldResult.setValidationStatus(MapValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Coordinate Input");
        } else {
            validationFieldResult.setValidationStatus(MapValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Coordinate Input: Coordinate must be an Integer");
        } return validationFieldResult;

    }

    public ValidationResult validateInput(Map map) {
        ValidationResult validationResult = new ValidationResult();
        ValidationFieldResult validateMapInputResult = validateMapInput(map.getMapName());
        ValidationFieldResult validationFilenameResult = validateFilenameInput(map.getFilename());
        ValidationFieldResult validationCoordinatesResult = validateCoordinates(map.getXCoordinate(), map.getYCoordinate());
        if (validationFilenameResult.getValidationStatus() == MapValidationStatus.ERROR) {
            validationResult.getValidationFieldResultList().add(validateMapInputResult);
        }
        if (validationFilenameResult.getValidationStatus() == MapValidationStatus.ERROR) {
            validationResult.getValidationFieldResultList().add(validationFilenameResult);
        }
        if (validationCoordinatesResult.getValidationStatus() == MapValidationStatus.ERROR) {
            validationResult.getValidationFieldResultList().add(validationCoordinatesResult);
        }
        if (validationResult.getValidationFieldResultList().size() > 0) {
            validationResult.setMapValidationStatus(MapValidationStatus.ERROR);
        } else {
            validationResult.setMapValidationStatus(MapValidationStatus.SUCCESS);
        } return validationResult;
    }
}

