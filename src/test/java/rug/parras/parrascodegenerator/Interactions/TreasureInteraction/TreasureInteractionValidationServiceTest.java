package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureInteractionValidationServiceTest {

    Treasure treasure;
    TreasureInteractionValidationService validationService;


    @BeforeEach
    void setUp() {
        treasure = new Treasure();
        validationService = new TreasureInteractionValidationService();
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(5);
        treasure.setMap("city_market");
        treasure.setFileName("interaction.py");
        treasure.setArea("Rionnagen");
    }

    @Test
    void validateMapInput() {
        boolean isPatternMatchedValid = validationService.validateMapInput(treasure.getMap());
        boolean isPatternMatchedNotValid1 = validationService.validateMapInput("test_map_for_Map_interaction");
        boolean isPatternMatchedNotValid2 = validationService.validateMapInput("Test_city_market_Map");
        boolean isPatternMatchedNotValid3 = validationService.validateMapInput("test_City 3");
        boolean isPatternMatchedNotValid4 = validationService.validateMapInput("test map_city");

        assertTrue(isPatternMatchedValid);
        assertFalse(isPatternMatchedNotValid1);
        assertFalse(isPatternMatchedNotValid2);
        assertFalse(isPatternMatchedNotValid3);
        assertFalse(isPatternMatchedNotValid4);
    }

    @Test
    void validateAreaInput() {
        boolean isPatternMatchedValid = validationService.validateAreaInput(treasure.getArea());
        boolean isPatternMatchedNotValid1 = validationService.validateAreaInput("rionnagen");
        boolean isPatternMatchedNotValid2 = validationService.validateAreaInput("Rionagg3n");
        boolean isPatternMatchedNotValid3 = validationService.validateAreaInput("Rionnagen ");
        boolean isPatternMatchedNotValid4 = validationService.validateAreaInput(" Rionnagen");

        assertTrue(isPatternMatchedValid);
        assertFalse(isPatternMatchedNotValid1);
        assertFalse(isPatternMatchedNotValid2);
        assertFalse(isPatternMatchedNotValid3);
        assertFalse(isPatternMatchedNotValid4);
    }

    @Test
    void validateFileNameInput() {
        boolean isPatternMatchedValid = validationService.validateFileNameInput(treasure.getFileName());
        boolean isPatternMatchedNotValid1 = validationService.validateFileNameInput("Interaction.py");
        boolean isPatternMatchedNotValid2 = validationService.validateFileNameInput("interaction.txt");
        boolean isPatternMatchedNotValid3 = validationService.validateFileNameInput("interactionpy");
        boolean isPatternMatchedNotValid4 = validationService.validateFileNameInput("interaction.pys");

        assertTrue(isPatternMatchedValid);
        assertFalse(isPatternMatchedNotValid1);
        assertFalse(isPatternMatchedNotValid2);
        assertFalse(isPatternMatchedNotValid3);
        assertFalse(isPatternMatchedNotValid4);
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

        boolean patternMatched = validationService.validateAmount(treasure.getItemOneAmount());
        assertTrue(patternMatched);
        assertFalse(validationService.validateAmount(10));
        assertFalse(validationService.validateAmount(102));


    }
}