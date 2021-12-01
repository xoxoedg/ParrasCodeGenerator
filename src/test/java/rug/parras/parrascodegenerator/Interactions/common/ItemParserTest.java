package rug.parras.parrascodegenerator.Interactions.common;

import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.Treasure;

import static org.junit.jupiter.api.Assertions.*;

class ItemParserTest {

    @Test
    void convertInputToMethodItemName() {
        Treasure treasure = new Treasure();
        treasure.setItemOneName("Life_serum");
        String expectedMethodItemName = "RECEIVE_LIFE_SERUM";
        String actualMethodItemName = ItemParser.convertInputToMethodItemName(treasure.getItemOneName());
        assertEquals(expectedMethodItemName, actualMethodItemName);

    }
}