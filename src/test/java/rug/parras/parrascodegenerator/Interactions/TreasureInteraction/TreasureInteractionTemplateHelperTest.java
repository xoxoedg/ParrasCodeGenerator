package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

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
        assertEquals(testMap, treasureInteractionTemplateHelper.listToMapConverter(testItemtList, testAmountList));
    }

    @Test
    void convertMapToFinalTemplateList() {
        List<String> expectedTemplateList = List.of("hero.items.tent.amount += 2", "hero.items.serum.amount += 3");

        treasure.setItemOneName("tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemOneAmount(2);
        treasure.setItemTwoAmount(3);
        List<String> actualTemplateList = treasureInteractionTemplateHelper.convertMapToFinalTemplateList(treasure);

        assertEquals(expectedTemplateList.get(0), actualTemplateList.get(0));
        assertEquals(expectedTemplateList.size(), actualTemplateList.size());
        assertEquals(expectedTemplateList.get(1), expectedTemplateList.get(1));
    }

    @Test
    void generateFunctionArguments() {
        String expectedFunctionArguments = "(timeline, 'RECEIVED_citymarketmap_CHEST, tent)";
        treasure.setAmountGold(0);
        treasure.setItemOneName("tent");
        treasure.setMap("citymarketmap");
        treasure.setItemOneAmount(3);
        String actualFunctionArguments = treasureInteractionTemplateHelper.generateFunctionArguments(treasure);
        assertEquals(expectedFunctionArguments, actualFunctionArguments);
    }
}