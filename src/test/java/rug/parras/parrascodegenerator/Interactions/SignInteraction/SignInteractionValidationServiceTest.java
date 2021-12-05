package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SignInteractionValidationServiceTest {

    private Sign sign;
    private SignInteractionValidationService validationService;


    @BeforeEach
    void setUp() {
        validationService = new SignInteractionValidationService();
        sign = new Sign();
    }

//    @Test
////   @ParameterizedTest({})//Todo
//    void validateDirectionInput() {
//        boolean validDirection1 = validationService.validateDirectionInput("up");
//        boolean validDirection2 = validationService.validateDirectionInput("DOWN");
//        boolean validDirection3 = validationService.validateDirectionInput("LEfT");
//        boolean validDirection4 = validationService.validateDirectionInput("riGht");
//        boolean notValidDirection1 = validationService.validateDirectionInput("right ");
//        boolean notValidDirection2 = validationService.validateDirectionInput("tomate");
//
//        assertTrue(validDirection1);
//        assertTrue(validDirection2);
//        assertTrue(validDirection3);
//        assertTrue(validDirection4);
//        assertFalse(notValidDirection1);
//        assertFalse(notValidDirection2);
//    }
//
//    @Test
//    void validateSignText() {
//        boolean validSignText = validationService.validateSignText("098123mdsqasd-- Asdi"); //20
//        boolean notValidSignText1 = validationService.validateSignText("098123mdsqasd-- asdsdkleaAsdkansdnasdasd");
//        boolean notValidSignText2 = validationService.validateSignText("098123mdsqasd-- asdiT");
//        assertTrue(validSignText);
//        assertFalse(notValidSignText1);
//        assertFalse(notValidSignText2);
//    }
}