package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureComponentGeneratorTest {
    Treasure treasure;
    TreasureComponentGenerator treasureComponentGenerator;

    @BeforeEach
    void setUp() {
        treasure = new Treasure();
        treasureComponentGenerator = new TreasureComponentGenerator();
    }

    @Test
    void generateClassName() {
        treasure.setMap("city_lake_map");
        String expectedClassName = "class CityLakeMapChestInteraction(StandardTreasureInteraction):\n";
        String actualClassName = treasureComponentGenerator.generateClassName(treasure);
        assertEquals(expectedClassName, actualClassName);
    }

    @Test
    void generateClassConstructorOnlyGold() {
        treasure.setMap("estuary_map");
        treasure.setAmountGold(100);
        String expectedClassName =
                "def __init__(self, timeline):\n" +
                "\t\tsuper(EstuaryMapChestInteraction, self).__init__(timeline, 'RECEIVED_CHEST_ESTUARY_MAP', RECEIVE_GOLD)";
        String actualClassName = treasureComponentGenerator.generateClassConstructor(treasure);
        assertEquals(expectedClassName, actualClassName);
    }

    @Test
    void generateClassConstructorGoldAndItem() {
        treasure.setMap("estuary_map");
        treasure.setAmountGold(100);
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(3);
        String expectedClassConstructor =
                "def __init__(self, timeline):\n" +
                        "\t\tsuper(EstuaryMapChestInteraction, self).__init__(timeline, 'RECEIVED_CHEST_ESTUARY_MAP', RECEIVE_GOLD_TENT)";
        String actualClassConstructor = treasureComponentGenerator.generateClassConstructor(treasure);
        assertEquals(expectedClassConstructor, actualClassConstructor);
    }

    @Test
    void generateRetrieveChestMethod() {
        treasure.setMap("city_lake_map");
        treasure.setItemOneName("tent");
        treasure.setItemOneAmount(1);
        String expectedCRetrieveChestMethod =
                "def retrieve_chest_content(self, hero):\n" +
                "\t\tItemFinder.add_to_items(hero, 'Tent', 1)";
        String actualRetrieveChestMethod = treasureComponentGenerator.generateRetrieveChestMethod(treasure);
        assertEquals(expectedCRetrieveChestMethod, actualRetrieveChestMethod);
    }

    @Test
    void generateRetrieveChestMethodWithSuperItem() {
        treasure.setMap("city_lake_map");
        treasure.setItemOneName("super potion");
        treasure.setItemOneAmount(1);
        String expectedCRetrieveChestMethod =
                "def retrieve_chest_content(self, hero):\n" +
                "\t\tItemFinder.add_to_items(hero, 'Super Potion', 1)";
        String actualRetrieveChestMethod = treasureComponentGenerator.generateRetrieveChestMethod(treasure);
        assertEquals(expectedCRetrieveChestMethod, actualRetrieveChestMethod);
    }

    @Test
    void generateRetrieveChestMethodGoldAndTwoItems() {
        treasure.setMap("city_lake_map");
        treasure.setItemOneName("tent");
        treasure.setItemOneAmount(1);
        treasure.setItemTwoName("Serum");
        treasure.setItemTwoAmount(10);
        treasure.setItemThreeName("pOtIoN");
        treasure.setItemThreeAmount(5);
        treasure.setAmountGold(300);
        String expectedCRetrieveChestMethod =
                "def retrieve_chest_content(self, hero):\n"+
                "\t\tItemFinder.add_to_items(hero, 'Tent', 1)\n" +
                "\t\tItemFinder.add_to_items(hero, 'Potion', 5)\n" +
                "\t\tItemFinder.add_to_items(hero, 'Serum', 10)\n" +
                "\t\thero.gold += 300";
        String actualRetrieveChestMethod = treasureComponentGenerator.generateRetrieveChestMethod(treasure);
        assertEquals(expectedCRetrieveChestMethod, actualRetrieveChestMethod);
    }
    @Test
    void generateRewardListGoldAndThreeItems() {
        treasure.setItemOneName("TeNt");
        treasure.setItemTwoName("Serum");
        treasure.setItemThreeName("pOtIoN");
        treasure.setAmountGold(300);
        String expectedRewardList = "RECEIVE_GOLD_TENT_SERUM_POTION = ['Received 300 Gold and Tent and Serum and Potion']";
        String actualRewardList = treasureComponentGenerator.generateRewardList(treasure);
        assertEquals(expectedRewardList, actualRewardList);
    }

    @Test
    void generateRewardListWithSuperItem() {
        treasure.setItemOneName("Super potion");
        treasure.setItemTwoName("Tent");
        String expectedRewardList = "RECEIVE_SUPER_POTION_TENT = ['Received Super Potion and Tent']";
        String actualRewardList = treasureComponentGenerator.generateRewardList(treasure);
        assertEquals(expectedRewardList, actualRewardList);
    }

    @Test
    void generateRewardListOnlyGold() {
        treasure.setAmountGold(300);
        String expectedRewardList = "RECEIVE_GOLD = ['Received 300 Gold']";
        String actualRewardList = treasureComponentGenerator.generateRewardList(treasure);
        assertEquals(expectedRewardList, actualRewardList);
    }

    @Test
    void generateRewardListOnlyItem() {
        treasure.setItemOneName("TeNT");
        String expectedRewardList = "RECEIVE_TENT = ['Received Tent']";
        String actualRewardList = treasureComponentGenerator.generateRewardList(treasure);
        assertEquals(expectedRewardList, actualRewardList);
    }
}