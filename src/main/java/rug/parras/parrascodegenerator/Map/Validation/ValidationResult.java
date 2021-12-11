package rug.parras.parrascodegenerator.Map.Validation;

import lombok.Getter;
import lombok.Setter;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationResult {

    private ValidationStatus validationStatus;
    private List<ValidationFieldResult> validationFieldResultList = new ArrayList<>();
    private String url;
    private String message;

}
