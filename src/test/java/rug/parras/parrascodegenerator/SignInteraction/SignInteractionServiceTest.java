package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Utils.GeneratedCodeToFileConverter;


import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignInteractionServiceTest {

    Sign sign;

    @BeforeEach
    void setUp() {
         sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("CityMarket")
                .direction("Up")
                .fileName("signInteraction.py").build();
    }

    @Mock
    GeneratedCodeToFileConverter converter;

    @Mock
    PythonCodeGenerationService pythonCodeGenerationService;

    @InjectMocks
    SignInteractionService signInteractionService;


    @Test
    void createSignInteraction() throws IOException {
        when(pythonCodeGenerationService.createList(sign)).thenReturn("TestString1");
        when(pythonCodeGenerationService.createPythonCode(sign )).thenReturn("TestString2");
        signInteractionService.createSignInteraction(sign);
        verify(pythonCodeGenerationService, times(1)).createPythonCode(sign);
        verify(pythonCodeGenerationService, times(1)).createList(sign);
    }
}