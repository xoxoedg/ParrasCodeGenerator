package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreasureInteractionValidationServiceTest {

    private Treasure treasure;
    private TreasureInteractionValidationService validationService;


    @BeforeEach
    void setUp() {
        treasure = new Treasure();
        validationService = new TreasureInteractionValidationService();
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(5);
        treasure.setMap("city_market_map");
        treasure.setFileName("interaction.py");
        treasure.setArea("Rionnagen");
    }

    @Test
    void validateItem() {
        boolean isPatternMatchedValidItem1 = validationService.validateItem(treasure.getItemOneName());
        boolean isPatternMatchedValidItem2 = validationService.validateItem("Super Potion");
        boolean isPatternMatchedNotValidItem1 = validationService.validateItem("super Potion");
        boolean isPatternMatchedNotValidItem2 = validationService.validateItem("super_potion");
        boolean isPatternMatchedNotValidItem3 = validationService.validateItem("1dau");
        boolean isPatternMatchedNotValidItem4 = validationService.validateItem("Supe Potion");
        boolean isPatternMatchedNotValidItem5 = validationService.validateItem("Super Potions");


        assertTrue(isPatternMatchedValidItem1);
        assertTrue(isPatternMatchedValidItem2);
        assertFalse(isPatternMatchedNotValidItem1);
        assertFalse(isPatternMatchedNotValidItem2);
        assertFalse(isPatternMatchedNotValidItem3);
        assertFalse(isPatternMatchedNotValidItem4);
        assertFalse(isPatternMatchedNotValidItem5);

    }

    @Test
    void validateAmount() {

        boolean isPatternMatchedValid = validationService.validateAmount(treasure.getItemOneAmount());
        assertTrue(isPatternMatchedValid);
        assertFalse(validationService.validateAmount(10));
        assertFalse(validationService.validateAmount(102));


    }
}