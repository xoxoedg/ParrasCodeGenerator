package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.SignInteractionCodeGenerationService;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.SignInteractionService;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;

import java.io.File;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignInteractionServiceTest {

    private Sign sign = Sign.builder().fileName("signInteraction.py").build();

    @Mock
    private SignInteractionCodeGenerationService signInteractionCodeGenerationService;

    @Mock
    SignInteractionValidationService signInteractionValidationService;

    @InjectMocks
    private SignInteractionService signInteractionService;

    @Test
    void createSignInteraction() {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setInteractionValidationStatus(InteractionValidationStatus.SUCCESS);
        when(signInteractionValidationService.validateInput(sign)).thenReturn(validationResult);
        when(signInteractionCodeGenerationService.generateCodeForSignInteraction(sign)).thenReturn("TestString1");
        signInteractionService.createSignInteraction(sign);
        verify(signInteractionCodeGenerationService, times(1)).generateCodeForSignInteraction(sign);
        verify(signInteractionValidationService).validateInput(sign);

        File fileToDelete = new File(sign.getFileName());
        fileToDelete.delete();

    }
}