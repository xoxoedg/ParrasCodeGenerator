package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationStatus;

@Getter
@Setter
public class ValidationFileResult {

    private ValidationStatus validationStatus;
    private String message;
}
