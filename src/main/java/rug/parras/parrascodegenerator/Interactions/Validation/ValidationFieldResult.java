package rug.parras.parrascodegenerator.Interactions.Validation;

import lombok.*;

@Getter
@Setter
public class ValidationFieldResult {

    private ValidationStatus validationStatus;
    private String message;
}
