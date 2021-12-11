package rug.parras.parrascodegenerator.Map.Validation;

import lombok.Getter;
import lombok.Setter;
import rug.parras.parrascodegenerator.common.ValidationStatus;

@Getter
@Setter
public class ValidationFieldResult {

    private ValidationStatus validationStatus;
    private String message;


}
