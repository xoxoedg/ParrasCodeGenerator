package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class SignInteractionService {

    private final SignInteractionCodeGenerationService signInteractionCodeGenerationService;
    private final SignInteractionValidationService validationService;

    @Autowired
    public SignInteractionService(SignInteractionCodeGenerationService signInteractionCodeGenerationService, SignInteractionValidationService validationService) {
        this.signInteractionCodeGenerationService = signInteractionCodeGenerationService;
        this.validationService = validationService;
    }


    public ValidationResult createSignInteraction(Sign sign) {
        ValidationResult validationResult = validationService.validateInput(sign);
        if (validationResult.getInteractionValidationStatus() == InteractionValidationStatus.SUCCESS) {

            try {
                FileOperationsUtils.writeToFile(signInteractionCodeGenerationService.generateCodeForSignInteraction(sign),
                        new File("testPythonDir\\" + sign.getFileName()));
                validationResult.setUrl("index");
                return validationResult;
            } catch (IOException e) {
                log.error("Error" + e.getMessage());
                validationResult.setUrl("error");
                validationResult.setMessage("Following Exception occurred" + e.getMessage());
                return validationResult;
            }
        } else {
            validationResult.setUrl("signError");
            return validationResult;
        }
    }
}

