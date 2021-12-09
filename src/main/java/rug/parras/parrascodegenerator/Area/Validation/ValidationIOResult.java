package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationIOResult {
    private ValidationAreaStatus validationAreaStatus;
    private String message;
    private List<ValidationFileResult> validationFileResultsList = new ArrayList<>();
}
