package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TreasureInteractionServiceTest {

    @Mock
    TreasureComponentBuilder treasureComponentBuilder;

    @InjectMocks
    TreasureInteractionService treasureInteractionService;

    @Test
    void createTreasureInteraction() {
        Treasure treasure = new Treasure();
        treasure.setFileName("TreasureInteraction.py");
        when(treasureComponentBuilder.generateTreasureInteraction(treasure)).thenReturn("TestString1");
        treasureInteractionService.createTreasureInteraction(treasure);
        verify(treasureComponentBuilder, times(1)).generateTreasureInteraction(treasure);

        File fileToDelete = new File(treasure.getFileName());
        fileToDelete.delete();
    }
}