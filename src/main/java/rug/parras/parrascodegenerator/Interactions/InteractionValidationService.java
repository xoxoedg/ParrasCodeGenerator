package rug.parras.parrascodegenerator.Interactions;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationFieldResult;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationStatus;

@Service
public class InteractionValidationService {
    ValidationFieldResult validationFieldResult;

    public ValidationFieldResult validateMapInput(String map) {
        validationFieldResult = new ValidationFieldResult();
        boolean validMapInput = map.matches("[a-z]+((_[a-z]+)+)?_map_[a-z]{1,9}");
        if (validMapInput) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Map Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Map Input: Map Input must be lowercase and the delimiter must be an underscore");
        }
        return validationFieldResult;
    }

    public ValidationFieldResult validateAreaInput(String area) {
        validationFieldResult = new ValidationFieldResult();
        boolean validAreaInput = area.matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)?");
        if (validAreaInput) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Area Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Area Input: Area Input must start with a Uppercase letter and the " +
                    "delimiter must be a whitespace ");
        }
        return validationFieldResult;
    }

    public ValidationFieldResult validateFileNameInput(String filename) {
        validationFieldResult = new ValidationFieldResult();
        boolean validFilename = filename.matches("[a-z]+_?[a-z]+\\.py");
        if (validFilename) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Filename");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Filename Input: Filename must be lowercase and end with .py");
        } return validationFieldResult;
    }
}

