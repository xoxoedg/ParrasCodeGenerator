package rug.parras.parrascodegenerator.AreaGenerator.blub.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationAreaResult {
    private ValidationAreaStatus validationStatus;
    private String message;
    private String url;
}
