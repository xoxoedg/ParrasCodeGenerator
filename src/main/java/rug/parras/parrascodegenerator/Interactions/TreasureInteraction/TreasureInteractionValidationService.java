package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.common.ItemAmountListConverter;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationFieldResult;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationStatus;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TreasureInteractionValidationService extends InteractionValidationService {
    private ValidationFieldResult validationFieldResult;
    private final List<String> validItems = List.of("Potion", "potion", "Ether", "ether",
            "Serum", "serum", "Herb", "herb", "Tent", "tent",
            "Super Potion", "super potion", "Super Ether", "super ether");

    public ValidationFieldResult validateItem(List<String> items) {
        validationFieldResult = new ValidationFieldResult();
        boolean itemsValid = items.stream().allMatch(validItems::contains);
        if (itemsValid) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Item Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Item Input: Items must be one of the following:" +
                    "Potion, Ether, Serum, Herb, Tent, Super Potion, Super Ether");
        }
        return validationFieldResult;
    }

    public ValidationFieldResult validateQuantityOfItems(List<String> items) {
        validationFieldResult = new ValidationFieldResult();
        Set<String> compareItemSet = items.stream().map(String::toLowerCase).collect(Collectors.toSet());
        if (items.size() == compareItemSet.size()) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Items Quantity");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("You have Duplicate Items entered. You can only enter an Item once");
        }
        return validationFieldResult;
    }


    public ValidationFieldResult validateItemAmount(List<String> itemAmount) {
        validationFieldResult = new ValidationFieldResult();
        String amountPattern = "^[1-9]";
        boolean validItemAmount = itemAmount.stream().allMatch(x -> x.matches(amountPattern));
        if (validItemAmount) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Amount");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Amount Input: Item Amount must be between 0-9 and only contain digits");
        }
        return validationFieldResult;
    }

    public ValidationFieldResult validateGoldAmount(int gold) {
        validationFieldResult = new ValidationFieldResult();
        String goldPattern = "0|[1-9]([0-9]{0,3})?";
        if (String.valueOf(gold).matches(goldPattern)) {
            validationFieldResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationFieldResult.setMessage("Valid Gold Input");
        } else {
            validationFieldResult.setValidationStatus(ValidationStatus.ERROR);
            validationFieldResult.setMessage("Invalid Gold Input: Gold must be an Integer and at least 1 Gold and at most 999 Gold" +
                    "is allowed");
        }
        return validationFieldResult;
    }


    public ValidationResult validateInput(Treasure treasure) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.getValidationFieldResultList().add(validateMapInput(treasure.getMap()));
        validationResult.getValidationFieldResultList().add(validateAreaInput(treasure.getArea()));
        validationResult.getValidationFieldResultList().add(validateFileNameInput(treasure.getFileName()));
        validationResult.getValidationFieldResultList().add(validateGoldAmount(treasure.getAmountGold()));
        validationResult.getValidationFieldResultList().add(validateItem(ItemAmountListConverter.filterItems(treasure)));
        validationResult.getValidationFieldResultList().add(validateQuantityOfItems(ItemAmountListConverter.filterItems(treasure)));
        validationResult.getValidationFieldResultList().add(validateItemAmount(ItemAmountListConverter.filterAmount(treasure)));
        boolean allFieldsValid = validationResult.getValidationFieldResultList().stream().allMatch(x -> x.getValidationStatus() == ValidationStatus.SUCCESS);

        if (allFieldsValid) {
            validationResult.setValidationStatus(ValidationStatus.SUCCESS);
        } else {
            List<ValidationFieldResult> errors = validationResult.getValidationFieldResultList().stream().filter(x -> x.getValidationStatus() == ValidationStatus.ERROR).collect(Collectors.toList());
            validationResult.setValidationFieldResultList(errors);
            validationResult.setValidationStatus(ValidationStatus.ERROR);
        }
        return validationResult;
    }
}



