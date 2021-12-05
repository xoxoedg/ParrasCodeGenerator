package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.common.ValidationFieldResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationStatus;

import java.util.List;

import static rug.parras.parrascodegenerator.Interactions.common.ValidationStatus.ERROR;
import static rug.parras.parrascodegenerator.Interactions.common.ValidationStatus.SUCCESS;

@Service
public class TreasureInteractionValidationService extends InteractionValidationService {
    private ValidationFieldResult validationFieldResult;
    private List<String> validItems = List.of("Potion", "Ether", "Serum", "Herb", "Tent", "Super Potion", "Super Ether");


    public ValidationFieldResult validateItem(String item) {
        validationFieldResult = new ValidationFieldResult();
        boolean validItem = validItems.contains(item);
        if (validItem) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Item Input");
        } else {
            validationFieldResult.setValidationStatus(ERROR);
            validationFieldResult.setMessage("Invalid Item Input: Items must be one of the following:" +
                    "Potion, Ether, Serum, Herb, Tent, Super Potion, Super Ether");
        }
        return validationFieldResult;
    }

    public ValidationFieldResult validateAmount(int itemAmount) {
        validationFieldResult = new ValidationFieldResult();
        String amountPattern = "^[1-9]";
        boolean validItemAmount = String.valueOf(itemAmount).matches(amountPattern);
        if (validItemAmount && itemAmount != 0) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Amount");
        } else {
            validationFieldResult.setValidationStatus(ERROR);
            validationFieldResult.setMessage("Invalid Amount Input: Item Amount must be between 0-9 and only contain digits");
        } return validationFieldResult;
    }

    public ValidationResult validateInput(Treasure treasure) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.getValidationFieldResultList().add(validateMapInput(treasure.getMap()));
        validationResult.getValidationFieldResultList().add(validateAreaInput(treasure.getArea()));
        validationResult.getValidationFieldResultList().add(validateFileNameInput(treasure.getFileName()));
        validationResult.getValidationFieldResultList().add(validateItem(treasure.getItemOneName()));
        validationResult.getValidationFieldResultList().add(validateAmount(treasure.getItemOneAmount()));
        boolean allFieldsValid = validationResult.getValidationFieldResultList().stream().allMatch(x -> x.getValidationStatus() == SUCCESS);

        if (allFieldsValid) {
            validationResult.setValidationStatus(SUCCESS);
        }  else {
            validationResult.setValidationStatus(ERROR);
        } return validationResult;
    }
}



