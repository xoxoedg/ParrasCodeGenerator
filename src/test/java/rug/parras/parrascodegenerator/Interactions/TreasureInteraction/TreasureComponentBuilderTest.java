package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureComponentBuilderTest {

    Treasure treasureOneItemAndGold;
    TreasureComponentBuilder treasureComponentBuilder = new TreasureComponentBuilder();

    @BeforeEach
    void setUp() {

        treasureOneItemAndGold = new Treasure();
        treasureOneItemAndGold.setItemOneName("Tent");
        treasureOneItemAndGold.setItemOneAmount(5);
        treasureOneItemAndGold.setAmountGold(300);
        treasureOneItemAndGold.setMap("way_to_malaiche");
    }

    @Test
    void generateClassName() {
        String expectedClassName = "class WayToMalaicheChestInteraction(StandardTreasureInteraction):";
        String actualClassName = treasureComponentBuilder.generateClassName(treasureOneItemAndGold).trim();
        assertEquals(expectedClassName, actualClassName);
    }

    @Test
    void generateClassConstructor() {
    }

    @Test
    void generateConstructorArguments() {
    }

    @Test
    void generateSuperMethod() {
    }

    @Test
    void generateSuperMethodArguments() {
    }

    @Test
    void generateTimeLineString() {
    }

    @Test
    void generateRetrieveChestMethod() {
    }

    @Test
    void generateItemFinderMethod() {
    }

    @Test
    void generateItemFinderArguments() {
    }

    @Test
    void generateGoldEarned() {
    }

    @Test
    void generateRewardList() {
    }

    @Test
    void generateRewardsListName() {
    }

    @Test
    void generateListMessage() {
    }

    @Test
    void filterAmount() {
    }

    @Test
    void filterItems() {
    }

    @Test
    void convertListToMap() {
    }
}