package rug.parras.parrascodegenerator.Interactions.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationResult {

    private ValidationStatus validationStatus;
    private List<ValidationFieldResult> validationFieldResultList = new ArrayList<>();
}
