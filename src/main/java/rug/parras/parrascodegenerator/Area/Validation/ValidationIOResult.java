package rug.parras.parrascodegenerator.Area.Validation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationIOResult extends ValidationResult{
    private List<ValidationFileResult> validationFileResultsList = new ArrayList<>();
}
