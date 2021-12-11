package rug.parras.parrascodegenerator.Interactions.Validation;

import lombok.*;
import rug.parras.parrascodegenerator.common.ValidationStatus;

@Getter
@Setter
public class ValidationFieldResult {

    private ValidationStatus validationStatus;
    private String message;
}
