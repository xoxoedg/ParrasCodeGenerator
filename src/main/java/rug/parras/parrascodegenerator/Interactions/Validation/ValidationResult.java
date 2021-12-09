package rug.parras.parrascodegenerator.Interactions.Validation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationResult {

    private InteractionValidationStatus interactionValidationStatus;
    private List<ValidationFieldResult> validationFieldResultList = new ArrayList<>();
    private String url;
}
