package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.common.ValidationStatus;


@Getter
@Setter
@Service
public class ValidationAreaService {

    public ValidationAreaResult validateAreaInput(String areaName) {

        ValidationAreaResult validationAreaResult = new ValidationAreaResult();
        boolean validAreaInput = areaName.matches("[a-zA-Z]+(( ([a-zA-Z]+))+)?");

        if (validAreaInput) {
            validationAreaResult.setValidationStatus(ValidationStatus.SUCCESS);
            validationAreaResult.setMessage("Valid Area Input");
        } else {
            validationAreaResult.setValidationStatus(ValidationStatus.ERROR);
            validationAreaResult.setMessage("Invalid Area Input:  Delimiter must be a whitespace");
        }
        return validationAreaResult;
    }
}
