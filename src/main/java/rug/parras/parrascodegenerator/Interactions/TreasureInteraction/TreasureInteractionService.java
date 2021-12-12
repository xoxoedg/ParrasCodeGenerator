package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.Validation.TreasureInteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class TreasureInteractionService {

    private final TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService;
    private final TreasureInteractionValidationService validationService;

    @Autowired
    public TreasureInteractionService(TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService, TreasureInteractionValidationService validationService) {
        this.treasureInteractionCodeGenerationService = treasureInteractionCodeGenerationService;
        this.validationService = validationService;
    }

    public ValidationResult createTreasureInteraction(Treasure treasure) {
        ValidationResult validationResult = validationService.validateInput(treasure);
        if (validationResult.getValidationStatus() == ValidationStatus.SUCCESS) {
            try {
                FileOperationsUtils.writeToFile(treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure),
                        new File("testPythonDir/" + treasure.getFileName().toLowerCase()));
                validationResult.setUrl("index");
                return validationResult;
            } catch (IOException e) {
                log.error("Error" + e.getMessage());
                validationResult.setValidationStatus(ValidationStatus.ERROR);
                validationResult.setUrl("error");
                validationResult.setMessage("Following Exception occurred" + e.getMessage());
                return validationResult;
            }
        } else {
            validationResult.setUrl("treasureError");
            return validationResult;
        }
    }
}


