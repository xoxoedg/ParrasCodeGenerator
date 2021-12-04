package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TreasureInteractionServiceTest {

    @Mock
    TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService;
    @InjectMocks
    TreasureInteractionService treasureInteractionService;


    @Test
    void generateTreasureInteractionClass() {
        Treasure treasure = new Treasure();

        treasure.setMap("city_market");
        treasure.setItemOneName("life_serum");
        treasure.setItemOneAmount(3);
    }
}