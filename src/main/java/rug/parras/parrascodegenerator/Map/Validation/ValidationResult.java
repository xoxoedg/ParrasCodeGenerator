package rug.parras.parrascodegenerator.Map.Validation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationResult {

    private MapValidationStatus mapValidationStatus;
    private List<ValidationFieldResult> validationFieldResultList = new ArrayList<>();
    private String url;

}