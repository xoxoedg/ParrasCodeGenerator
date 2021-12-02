package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.Test;

class TreasureInteractionCodeGenerationServiceTest {

    @Test
    void createTreasureInteractionClass() {
        Treasure treasure = new Treasure();

        treasure.setMap("city_market");
        treasure.setItemOneName("life_serum");
        treasure.setItemOneAmount(3);


        TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService = new TreasureInteractionCodeGenerationService();
        System.out.println(treasureInteractionCodeGenerationService.generateTreasureInteractionClass(treasure));
    }
}