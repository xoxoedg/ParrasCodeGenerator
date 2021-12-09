package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

@Service
public class SignInteractionService {

    SignInteractionCodeGenerationService signInteractionCodeGenerationService;
    SignInteractionValidationService validationService;

    @Autowired
    public SignInteractionService(SignInteractionCodeGenerationService signInteractionCodeGenerationService, SignInteractionValidationService validationService) {
        this.signInteractionCodeGenerationService = signInteractionCodeGenerationService;
        this.validationService = validationService;
    }


    public ValidationResult createSignInteraction(Sign sign) {
        ValidationResult validationResult = validationService.validateInput(sign);
        if (validationResult.getInteractionValidationStatus() == InteractionValidationStatus.SUCCESS) {
            validationResult.setUrl("index");
            try {
                FileOperationUtils converter = new FileOperationUtils("testPythonDir\\" + sign.getFileName());
                converter.writeToFile(signInteractionCodeGenerationService.generateCodeForSignInteraction(sign));

            } catch (IOException e) {
                e.printStackTrace();
            }
            return validationResult;
        } else {
            validationResult.setUrl("signError");
            return validationResult;
        }
    }
}

