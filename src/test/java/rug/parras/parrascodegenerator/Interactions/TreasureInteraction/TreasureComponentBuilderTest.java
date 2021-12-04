package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class TreasureComponentBuilderTest {
    Treasure treasure;
    private static final String TIMELINE_STRING = "RECEIVED_CHEST_";
    TreasureComponentBuilder treasureComponentBuilder;

    @BeforeEach
    void setUp() {
        treasure = new Treasure();
        treasureComponentBuilder = new TreasureComponentBuilder();
    }





    @Test
    void generateTimeLineString() {
        String expectedTimelineString = "RECEIVED_CHEST_WAY_TO_BALCONY";
        treasure.setMap("WAY_TO_BALCONY".toLowerCase());
        String actualTimelineString = treasureComponentBuilder.generateTimeLineString(treasure);
        System.out.println(expectedTimelineString);
        assertEquals(expectedTimelineString, actualTimelineString);
    }

    @Test
    void generateSuperMethod() {
        String expectedSuperMethod = "super(WayToBalconyChestInteraction, self)";
        treasure.setMap("WAY_TO_BALCONY");
        String actualSuperMethod = treasureComponentBuilder.generateSuperMethod(treasure);
        System.out.println(actualSuperMethod);
        assertEquals(expectedSuperMethod,actualSuperMethod);
    }

    @Test
    void generateSuperMethodArguments() {
        String expectedTimelineString = "(WayToBalconyChestInteraction, self)";
        treasure.setMap("WAY_TO_BALCONY");
        String actualTimelineString = treasureComponentBuilder.generateSuperMethodArguments(treasure);
        System.out.println(expectedTimelineString);
        assertEquals(expectedTimelineString, actualTimelineString);
    }

    @Test
    void generateRewardsListNameItemsAndGold() {
        String expectedTimelineString = "RECEIVE_GOLD_TENT_SWORD";
        treasure.setAmountGold(100);
        treasure.setItemOneName("Tent");
        treasure.setItemTwoName("SWORD");
        treasure.setItemOneAmount(5);
        String actualTimelineString = treasureComponentBuilder.generateRewardsListName(treasure);
        System.out.println(expectedTimelineString);
        assertEquals(expectedTimelineString, actualTimelineString);
    }

    @Test
    void generateRewardsListNameOnlyItems() {
        String expectedTimelineString = "RECEIVE_TENT_SWORD";
        treasure.setItemOneName("Tent");
        treasure.setItemTwoName("SWORD");
        treasure.setItemOneAmount(5);
        String actualTimelineString = treasureComponentBuilder.generateRewardsListName(treasure);
        System.out.println(expectedTimelineString);
        assertEquals(expectedTimelineString, actualTimelineString);
    }

    @Test
    void generateRewardsListNameOnlyGold() {
        String expectedTimelineString = "RECEIVE_GOLD";
        treasure.setAmountGold(150);
        String actualTimelineString = treasureComponentBuilder.generateRewardsListName(treasure);
        System.out.println(expectedTimelineString);
        assertEquals(expectedTimelineString, actualTimelineString);
    }

    @Test
    void generateConstructorArguments() {
        String expectedTimelineString = "(timeline, 'RECEIVED_CHEST_WAY_TO_BALCONY', RECEIVE_GOLD)";
        treasure.setMap("way_to_balcony");
        treasure.setAmountGold(150);
        String actualTimelineString = treasureComponentBuilder.generateConstructorArguments(treasure);
        System.out.println(expectedTimelineString);
        assertEquals(expectedTimelineString, actualTimelineString);
    }

    @Test
    void generateClassConstructor() {
        String expectedClassConstructor =
                "    def __init__(self, timeline):\n" +
                        "        super(WayToBalconyChestInteraction, self).__init__(timeline, 'RECEIVED_WAY_TO_BALCONY_CHEST', RECEIVE_SERUM)";

        treasure.setItemOneName("Serum");
        treasure.setMap("way_to_balcony");
        String actualClassConstructor = treasureComponentBuilder.generateClassConstructor(treasure);
        System.out.println(actualClassConstructor);

        assertEquals(expectedClassConstructor, actualClassConstructor);


    }

    @Test
    void generateListMessage() {
        String expectedMessage = "Received Herb and 100 Gold!";
        treasure.setItemOneName("Herb");
        treasure.setAmountGold(100);
        String actualMessage =  treasureComponentBuilder.generateListMessage(treasure);
        System.out.println(actualMessage);
        assertEquals(expectedMessage, actualMessage);


    }

    @Test
    void generateRewardList() {
        String expectedMessage = "RECEIVE_GOLD_TENT = Received100 Goldtent";
        treasure.setItemOneName("Tent");
        treasure.setAmountGold(100);
        String actualMessage =  treasureComponentBuilder.generateRewardList(treasure);
        System.out.println(actualMessage);
        assertEquals(expectedMessage, actualMessage);

    }

//    @Test
//    void generateTreasureInteraction() {
//        treasure.setItemOneName("Tent");
//        treasure.setItemTwoName("Serum");
//        treasure.setItemTwoAmount(3);
//        treasure.setAmountGold(100);
//        treasure.setItemOneAmount(3);
//        treasure.setMap("way_to_balcony");
//        String actualMessage =  treasureComponentBuilder.generateTreasureInteraction(treasure);
//        System.out.println(actualMessage);
//    }

    @Test
    void testGenerateTreasureInteraction() {
    }

    @Test
    void generateItemFinderArguments() {
        treasure.setItemOneName("Tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemTwoAmount(3);
        treasure.setAmountGold(100);
        treasure.setItemOneAmount(3);
        treasure.setMap("way_to_balcony");
        treasureComponentBuilder.generateItemFinderArguments(treasure);
    }

    @Test
    void generateItemFinderMethod() {
        String expectedValue =" ItemFinder.add_to_items(hero, 'Tent', 1)";
        treasure.setItemOneName("Tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemTwoAmount(3);
        treasure.setAmountGold(100);
        treasure.setItemOneAmount(3);
        treasure.setMap("way_to_balcony");
        String actualValue = treasureComponentBuilder.generateItemFinderMethod(treasure);
        System.out.println(actualValue);
    }

    @Test
    void generateRetrieveChestMethod() {
        String expectedValue =" ItemFinder.add_to_items(hero, 'Tent', 1)";
        treasure.setItemOneName("Tent");
        treasure.setItemTwoName("Serum");
        treasure.setItemTwoAmount(3);
        treasure.setAmountGold(100);
        treasure.setItemOneAmount(3);
        treasure.setMap("way_to_balcony");
        String actualRetrieveChestMethod = treasureComponentBuilder.generateRetrieveChestMethod(treasure);
        System.out.println(actualRetrieveChestMethod);
        }
    }
