package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.common.ItemAmountListConverter;
import rug.parras.parrascodegenerator.Interactions.common.ValidationFieldResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationStatus;

import java.util.List;
import java.util.stream.Collectors;

import static rug.parras.parrascodegenerator.Interactions.common.ValidationStatus.ERROR;
import static rug.parras.parrascodegenerator.Interactions.common.ValidationStatus.SUCCESS;

@Service
public class TreasureInteractionValidationService extends InteractionValidationService {
    private ValidationFieldResult validationFieldResult;
    private final List<String> validItems = List.of("Potion", "potion", "Ether","ether",
            "Serum","serum", "Herb","herb", "Tent","tent",
            "Super Potion", "super potion", "Super Ether", "super ether");

    public ValidationFieldResult validateItem(List<String> items) {
        validationFieldResult = new ValidationFieldResult();
        boolean itemsValid = items.stream().allMatch(validItems::contains);
        if (itemsValid) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Item Input");
        } else {
            validationFieldResult.setValidationStatus(ERROR);
            validationFieldResult.setMessage("Invalid Item Input: Items must be one of the following:" +
                    "Potion, Ether, Serum, Herb, Tent, Super Potion, Super Ether");
        }
        return validationFieldResult;
    }

    public ValidationFieldResult validateAmount(List<String> itemAmount) {
        validationFieldResult = new ValidationFieldResult();
        String amountPattern = "^[1-9]";
        boolean validItemAmount = itemAmount.stream().allMatch(x -> x.matches(amountPattern));
        if (validItemAmount) {
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
        validationResult.getValidationFieldResultList().add(validateItem(ItemAmountListConverter.filterItems(treasure)));
        validationResult.getValidationFieldResultList().add(validateAmount(ItemAmountListConverter.filterAmount(treasure)));
        boolean allFieldsValid = validationResult.getValidationFieldResultList().stream().allMatch(x -> x.getValidationStatus() == SUCCESS);

        if (allFieldsValid) {
            validationResult.setValidationStatus(SUCCESS);
        }  else {
            validationResult.setValidationStatus(ERROR);
        } return validationResult;
    }
}



