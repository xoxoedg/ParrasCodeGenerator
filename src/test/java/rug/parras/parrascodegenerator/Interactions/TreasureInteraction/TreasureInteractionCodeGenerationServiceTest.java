package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreasureInteractionCodeGenerationServiceTest {

    private final String expectedValue =
    "from characters.item_interaction.common.standard_treasure_interaction import StandardTreasureInteraction\n" +
    "from characters.items import ItemFinder\n\n" +
            "RECEIVE_GOLD_TENT_SERUM = ['Received 100 Gold and Tent and Serum']\n" +
            "\n" +
            "class WayToMountainChestInteraction(StandardTreasureInteraction):\n" +
            "\n" +
            "\n" +
            "\tdef __init__(self, timeline):\n" +
            "\t\tsuper(WayToMountainChestInteraction, self).__init__.(timeline, 'RECEIVED_CHEST_WAY_TO_MOUNTAIN', RECEIVE_GOLD_TENT_SERUM)\n" +
            "\n" +
            "\tdef retrieve_chest_content(self, hero):\n" +
            "\t\tItemFinder.add_to_items(hero, tent, 3)\n" +
            "\t\tItemFinder.add_to_items(hero, serum, 3)\n" +
            "\t\thero.gold += 100";

    @Test
    void createTreasureInteractionClass() {
        Treasure treasure = new Treasure();
        TreasureComponentBuilder treasureComponentBuilder = new TreasureComponentBuilder();
        TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService = new TreasureInteractionCodeGenerationService(treasureComponentBuilder);
        treasure.setItemOneName("Tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemTwoAmount(3);
        treasure.setItemOneAmount(3);

        treasure.setAmountGold(100);

        treasure.setMap("way_to_mountain");

        String actualMessage = treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure);
        System.out.println(actualMessage);
        assertEquals(expectedValue, actualMessage);
    }
}
