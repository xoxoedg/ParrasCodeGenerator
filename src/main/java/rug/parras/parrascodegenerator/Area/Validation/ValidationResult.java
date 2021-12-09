package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ValidationResult {
    protected ValidationStatus validationStatus;
    protected String message;
    protected String url;
}
