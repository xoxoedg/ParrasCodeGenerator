package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.common.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.common.ValidationStatus;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

@Service
public class TreasureInteractionService {

    private TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService;
    private TreasureInteractionValidationService validationService;

    @Autowired
    public TreasureInteractionService(TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService, TreasureInteractionValidationService validationService) {
        this.treasureInteractionCodeGenerationService = treasureInteractionCodeGenerationService;
        this.validationService = validationService;
    }

    public ValidationResult createErrorModel(Treasure treasure) {
        return validationService.validateInput(treasure);
    }

    public String createTreasureInteraction(Treasure treasure) {
        if (validationService.validateInput(treasure).getValidationStatus() == ValidationStatus.SUCCESS) {
            try {
                FileOperationUtils converter = new FileOperationUtils("testPythonDir\\" + treasure.getFileName());
                converter.writeToFile(treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure));

            } catch (IOException e) {
                e.printStackTrace();
            }
            return "index";
        } else {
            return "error";
        }
    }
}


