package rug.parras.parrascodegenerator.Interactions.Validation;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationFieldResult;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SignInteractionValidationService extends InteractionValidationService {
    private ValidationFieldResult validationFieldResult;

    private List<String> validDirections = List.of("left", "right", "up", "down");

    public ValidationFieldResult validateDirectionInput(String direction) {
        validationFieldResult = new ValidationFieldResult();
        boolean isValid = validDirections.contains(direction.toLowerCase());
        if (isValid) {
            validationFieldResult.setMessage("Valid Input");
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFieldResult.setMessage("Direction must be one of the following: left, right, up, down");
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
        }
        return validationFieldResult;
    }


    public ValidationFieldResult validateSignText(String signText) {
        validationFieldResult  = new ValidationFieldResult();
        boolean validSignText = signText.matches(".{0,200}");
        if (validSignText) {
            validationFieldResult.setMessage("Valid Sign Input");
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            validationFieldResult.setMessage("Invalid Sign Input: Sign Text can contain at most of 20 character");
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
        }
        return validationFieldResult;
    }

    public ValidationResult validateInput(Sign sign) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.getValidationFieldResultList().add(validateMapInput(sign.getMap()));
        validationResult.getValidationFieldResultList().add(validateAreaInput(sign.getArea()));
        validationResult.getValidationFieldResultList().add(validateFileNameInput(sign.getFileName()));
        validationResult.getValidationFieldResultList().add(validateDirectionInput(sign.getDirection()));
        validationResult.getValidationFieldResultList().add(validateSignText(sign.getSignText()));

        boolean allFieldsValid = validationResult.getValidationFieldResultList().stream().allMatch(x -> x.getValidationStatus() == ValidationStatus.ERROR.SUCCESS);

        if (allFieldsValid) {
            validationResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            List<ValidationFieldResult> errors = validationResult.getValidationFieldResultList().stream().filter(x -> x.getValidationStatus() == ValidationStatus.ERROR).collect(Collectors.toList());
            validationResult.setValidationFieldResultList(errors);
            validationResult.setValidationStatus(ValidationStatus.ERROR);
        } return  validationResult;
    }
}
