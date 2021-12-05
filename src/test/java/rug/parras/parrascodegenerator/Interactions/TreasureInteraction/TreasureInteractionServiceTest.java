package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TreasureInteractionServiceTest {
    Treasure treasure;

    @Mock
    TreasureInteractionValidationService validationService;

    @Mock
    TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService;

    @InjectMocks
    TreasureInteractionService treasureInteractionService;

    @Test
    void createTreasureInteraction() {
        treasure = new Treasure();
        treasure.setFileName("TreasureInteraction.py");
        when(treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure)).thenReturn("String123");
        treasureInteractionService.createTreasureInteraction(treasure);
        verify(treasureInteractionCodeGenerationService).generateTreasureInteraction(treasure);
        File fileToDelete = new File(treasure.getFileName());
        fileToDelete.delete();
    }
}