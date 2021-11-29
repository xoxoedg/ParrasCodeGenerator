package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignInteractionServiceTest {

    private Sign sign = Sign.builder().fileName("signInteraction.py").build();

    @Mock
    private PythonCodeGenerationService pythonCodeGenerationService;

    @InjectMocks
    private SignInteractionService signInteractionService;

    @Test
    void createSignInteraction() {
        when(pythonCodeGenerationService.pythonCodeBuilder(sign)).thenReturn("TestString1");
        signInteractionService.createSignInteraction(sign);
        verify(pythonCodeGenerationService, times(1)).pythonCodeBuilder(sign);

        File fileToDelete = new File(sign.getFileName());
        fileToDelete.delete();
    }
}