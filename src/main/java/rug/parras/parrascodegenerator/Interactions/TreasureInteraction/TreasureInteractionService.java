package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.Validation.TreasureInteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

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
        if (validationResult.getInteractionValidationStatus() == InteractionValidationStatus.SUCCESS) {
            try {
                FileOperationUtils converter = new FileOperationUtils("testPythonDir\\" + treasure.getFileName());
                converter.writeToFile(treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure));
                validationResult.setUrl("index");
                return validationResult;
            } catch (IOException e) {
                log.error("Error"); // Logger
                validationResult.setInteractionValidationStatus(InteractionValidationStatus.ERROR);
                validationResult.setUrl("error");
                validationResult.setMessage("Following Exception occured" + e.getMessage());
                return validationResult;
            }
        } else {
            validationResult.setUrl("treasureError");
            return validationResult;
        }
    }
}


