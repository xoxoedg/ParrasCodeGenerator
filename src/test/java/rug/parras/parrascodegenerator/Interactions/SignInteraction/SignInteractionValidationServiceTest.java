package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Interactions.Validation.SignInteractionValidationService;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

class SignInteractionValidationServiceTest {

    private Sign sign;
    private SignInteractionValidationService signInteractionValidationService;

    @BeforeEach
    void setUp() {
        sign = new Sign();
        signInteractionValidationService = new SignInteractionValidationService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"left", "Left", "right", "Right", "up", "Up", "uP", "down", "Down", "DOWN", "LEFT"})
    void validateDirectionInputValid(String direction) {
        Enum<ValidationStatus> actualValue = signInteractionValidationService.validateDirectionInput(direction).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"lft", "3", "MountaIn"})
    void validateDirectionInputInvalid(String direction) {
        Enum<ValidationStatus> actualValue = signInteractionValidationService.validateDirectionInput(direction).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;

        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"i 3_d8KDaslsdmasdisa", "Hallo wie gehts"})
    void validateSignTextValid(String testSignText) {
        Enum<ValidationStatus> actualValue = signInteractionValidationService.validateSignText(testSignText).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }


    @Test
    void validateInputValid() {
        sign.setMap("wuff_FOUR_mAP");
        sign.setArea("Deadgead Mountain");
        sign.setFileName("Sign_interaction_FOR_Test.py");
        sign.setDirection("UP");
        sign.setSignText("Hello");
        Enum<ValidationStatus> actualValue = signInteractionValidationService.validateInput(sign).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateInputInvalid() {
        sign.setMap("wuff_map_four");
        sign.setArea("Deadgead   Mountain");
        sign.setFileName("signInteraction.txt");
        sign.setDirection("UP");
        sign.setSignText("Hello");
        Enum<ValidationStatus> actualValue = signInteractionValidationService.validateInput(sign).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;

        assertSame(expectedValue, actualValue);
    }

}

