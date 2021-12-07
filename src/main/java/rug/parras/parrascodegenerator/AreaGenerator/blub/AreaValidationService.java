package rug.parras.parrascodegenerator.AreaGenerator.blub;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.blub.common.ValidationAreaResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationStatus;
@Getter
@Setter
@Service
public class AreaValidationService {

    public ValidationAreaResult validateAreaInput(String areaName) {

        ValidationAreaResult validationAreaResult = new ValidationAreaResult();
        boolean validAreaInput = areaName.matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)?");

        if (validAreaInput) {
            validationAreaResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationAreaResult.setMessage("Valid Area Input");
        } else {
            validationAreaResult.setValidationStatus(ValidationStatus.ERROR);
            validationAreaResult.setMessage("Invalid Area Input: Area Input must start with a Uppercase letter and the " +
                    "delimiter must be a whitespace ");
        }
        return validationAreaResult;
    }
}
