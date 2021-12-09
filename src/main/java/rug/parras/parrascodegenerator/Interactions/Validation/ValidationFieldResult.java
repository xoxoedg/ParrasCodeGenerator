package rug.parras.parrascodegenerator.Interactions.Validation;

import lombok.*;

@Getter
@Setter
public class ValidationFieldResult {

    private InteractionValidationStatus interactionValidationStatus;
    private String message;
}
