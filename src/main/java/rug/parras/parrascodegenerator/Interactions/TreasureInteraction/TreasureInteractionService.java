package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.common.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationStatus;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

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
            validationResult.setUrl("index");
            try {
                FileOperationUtils converter = new FileOperationUtils("testPythonDir\\" + treasure.getFileName());
                converter.writeToFile(treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure));

            } catch (IOException e) {
                e.printStackTrace();
            }
            return validationResult;
        } else {
            validationResult.setUrl("treasureError");
            return validationResult;
        }
    }
}


