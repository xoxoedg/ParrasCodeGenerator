package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureInteractionComponentGeneratorTest {
    TreasureInteractionComponentGenerator treasureInteractionComponentGenerator;
    HashMap<String, String> testMap;
    Treasure treasure;

    @BeforeEach
    void setUp() {
        treasureInteractionComponentGenerator =  new TreasureInteractionComponentGenerator();
        treasure = new Treasure();
        testMap = new HashMap<>();
        testMap.put("Tent", "3");
        testMap.put("Potion", "4");
        testMap.put("Serum", "5");
    }

    @Test
    void listToMapConverter() {
        List<String> testAmountList = List.of("3", "4", "5");
        List<String> testItemtList = List.of("Tent", "Potion", "Serum");
        assertEquals(testMap, treasureInteractionComponentGenerator.convertListToMap(testItemtList, testAmountList));
    }

    @Test
    void convertMapToFinalTemplateList() {
        List<String> expectedTemplateList = List.of("hero.items.tent.amount += 2", "hero.items.serum.amount += 3");

        treasure.setItemOneName("tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemOneAmount(2);
        treasure.setItemTwoAmount(3);
        List<String> actualTemplateList = treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure);

        assertEquals(expectedTemplateList.get(0), actualTemplateList.get(0));
        assertEquals(expectedTemplateList.size(), actualTemplateList.size());
        assertEquals(expectedTemplateList.get(1), expectedTemplateList.get(1));
    }

    @Test
    void generateGoldEarned() {
        final String expectedGold = "hero.gold += 100";
        treasure.setAmountGold(100);
        String actualGold = treasureInteractionComponentGenerator.generateGoldEarned(treasure);
        assertEquals(expectedGold, actualGold);
    }

    @Test
    void generateGoldEarnedWith0() {
        final String expectedGold = "";
        treasure.setAmountGold(0);
        String actualGold = treasureInteractionComponentGenerator.generateGoldEarned(treasure);
        assertEquals(expectedGold, actualGold);
    }

    @Test
    void generateSuperMethod() {
        final String expectedSuperMethod = "super(CityMarketMapChestInteraction, self)";
        treasure.setMap("city_market_map");
        String actualSuperMethod = treasureInteractionComponentGenerator.generateSuperMethod(treasure);
        assertEquals(expectedSuperMethod, actualSuperMethod);
    }

    @Test
    void generateGoldList() {
        String expectedGenerateGoldList = "RECEIVE_GOLD_IN_CITY_MARKET_MAP = ['You receive 100 gold']";
        treasure.setMap("city_market_map");
        treasure.setAmountGold(100);
        String actualGeneratedGoldList = treasureInteractionComponentGenerator.generateGoldList(treasure);
        System.out.println(actualGeneratedGoldList);

        assertEquals(expectedGenerateGoldList, actualGeneratedGoldList);
    }

    @Test
    void generateItemList() {
        treasure.setItemOneName("Tent");
        List<String> expectedItemList= List.of("RECEIVE_TENT = ['Received Tent']");
        List<String> actualItemList = treasureInteractionComponentGenerator.generateItemList(treasure);
        System.out.println(actualItemList.get(0));
        assertEquals(expectedItemList.size(), actualItemList.size());
        assertEquals(expectedItemList.get(0), actualItemList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> actualItemList.get(1));
    }
}

//    @Test
//    void generateRetrieveChestMethodOnlyGold() {
//        final String expectedRetrieveChestMethod =
//                "def retrieve_chest_content(self, hero):\n" +
//                "    hero.gold += 100";
//        treasure.setAmountGold(100);
//        String actualRetrieveChestMethod = treasureInteractionTemplateHelper.generateRetrieveChestMethod(treasure).trim();
//        System.out.println(actualRetrieveChestMethod);
//        assertEquals(expectedRetrieveChestMethod, actualRetrieveChestMethod);
//
//    }
//}