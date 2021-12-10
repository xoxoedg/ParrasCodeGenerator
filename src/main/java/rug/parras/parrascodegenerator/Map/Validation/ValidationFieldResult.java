package rug.parras.parrascodegenerator.Map.Validation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationFieldResult {

    private MapValidationStatus validationStatus;
    private String message;


}
