package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureInteractionCodeGenerationServiceTest {

    @Test
    void createTreasureInteractionClass() {
        Treasure treasure = new Treasure();
        treasure.setMap("city_market");
        treasure.setItemOneName("life_serum");
        treasure.setItemOneAmount(3);
        treasure.setAmountGold(100);
        treasure.setItemTwoName("potion");
        treasure.setItemTwoAmount(8);
        treasure.setItemThreeName("ether");
        treasure.setItemThreeAmount(10);

        TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService = new TreasureInteractionCodeGenerationService();
        System.out.println(treasureInteractionCodeGenerationService.createTreasureInteractionClass(treasure));
    }
}