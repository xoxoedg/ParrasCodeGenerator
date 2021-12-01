package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureInteractionTemplateHelperTest {
    TreasureInteractionTemplateHelper treasureInteractionTemplateHelper;
    HashMap<String, String> testMap;
    Treasure treasure;

    @BeforeEach
    void setUp() {
        treasureInteractionTemplateHelper =  new TreasureInteractionTemplateHelper();
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
        assertEquals(testMap, treasureInteractionTemplateHelper.convertListToMap(testItemtList, testAmountList));
    }

    @Test
    void convertMapToFinalTemplateList() {
        List<String> expectedTemplateList = List.of("hero.items.tent.amount += 2", "hero.items.serum.amount += 3");

        treasure.setItemOneName("tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemOneAmount(2);
        treasure.setItemTwoAmount(3);
        List<String> actualTemplateList = treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure);

        assertEquals(expectedTemplateList.get(0), actualTemplateList.get(0));
        assertEquals(expectedTemplateList.size(), actualTemplateList.size());
        assertEquals(expectedTemplateList.get(1), expectedTemplateList.get(1));
    }

//    @Test
//    void generateFunctionArguments() {
//        String expectedFunctionArguments = "(timeline, 'RECEIVED_CityMarketMap_CHEST, tent)";
//        treasure.setAmountGold(0);
//        treasure.setItemOneName("tent");
//        treasure.setMap("city_market_map");
//        treasure.setItemOneAmount(3);
//        String actualFunctionArguments = treasureInteractionTemplateHelper.generateFunctionArguments(treasure);
//        assertEquals(expectedFunctionArguments, actualFunctionArguments);


    @Test
    void generateGoldEarned() {
        final String expectedGold = "hero.gold += 100";
        treasure.setAmountGold(100);
        String actualGold = treasureInteractionTemplateHelper.generateGoldEarned(treasure);
        assertEquals(expectedGold, actualGold);
    }

    @Test
    void generateGoldEarnedWith0() {
        final String expectedGold = "";
        treasure.setAmountGold(0);
        String actualGold = treasureInteractionTemplateHelper.generateGoldEarned(treasure);
        assertEquals(expectedGold, actualGold);
    }

    @Test
    void generateSuperMethod() {
        final String expectedSuperMethod = "super(CityMarketMapChestInteraction, self)";
        treasure.setMap("city_market_map");
        String actualSuperMethod = treasureInteractionTemplateHelper.generateSuperMethod(treasure);
        assertEquals(expectedSuperMethod, actualSuperMethod);
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