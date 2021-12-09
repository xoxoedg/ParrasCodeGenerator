package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.Validation.ValidationAreaResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationAreaStatus;


@Getter
@Setter
@Service
public class AreaValidationService {

    public ValidationAreaResult validateAreaInput(String areaName) {

        ValidationAreaResult validationAreaResult = new ValidationAreaResult();
        boolean validAreaInput = areaName.matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)?");

        if (validAreaInput) {
            validationAreaResult.setValidationStatus(ValidationAreaStatus.SUCCESS);
            validationAreaResult.setMessage("Valid Area Input");
        } else {
            validationAreaResult.setValidationStatus(ValidationAreaStatus.ERROR);
            validationAreaResult.setMessage("Invalid Area Input: Area Input must start with a Uppercase letter and the " +
                    "delimiter must be a whitespace ");
        }
        return validationAreaResult;
    }
}
