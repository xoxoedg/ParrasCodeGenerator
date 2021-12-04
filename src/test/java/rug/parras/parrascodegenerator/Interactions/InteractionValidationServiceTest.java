package rug.parras.parrascodegenerator.Interactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.Treasure;
import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.TreasureInteractionValidationService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InteractionValidationServiceTest {

    private Treasure treasure;
    private InteractionValidationService validationService;


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
    void validateMapInput() {
        boolean isPatternMatchedValid = validationService.validateMapInput(treasure.getMap());
        boolean isPatternMatchedNotValid1 = validationService.validateMapInput("test_map_for_Map_interaction");
        boolean isPatternMatchedNotValid2 = validationService.validateMapInput("Test_city_market_Map");
        boolean isPatternMatchedNotValid3 = validationService.validateMapInput("test_City 3");
        boolean isPatternMatchedNotValid4 = validationService.validateMapInput("test map_city");
        boolean isPatternMatchedNotValid5 = validationService.validateMapInput("Test_city_market");

        assertTrue(isPatternMatchedValid);
        assertFalse(isPatternMatchedNotValid1);
        assertFalse(isPatternMatchedNotValid2);
        assertFalse(isPatternMatchedNotValid3);
        assertFalse(isPatternMatchedNotValid4);
        assertFalse(isPatternMatchedNotValid5);
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

}