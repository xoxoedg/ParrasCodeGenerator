package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationAreaResult {
    private ValidationAreaStatus validationStatus;
    private String message;
    private String url;
}
