package rug.parras.parrascodegenerator.Interactions.common;

import lombok.*;

@Getter
@Setter
public class ValidationFieldResult {

    private ValidationStatus validationStatus;
    private String message;
}
