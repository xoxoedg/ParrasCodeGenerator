package rug.parras.parrascodegenerator.Interactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationFieldResult;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

class InteractionValidationServiceTest {

    InteractionValidationService interactionValidationService;
    ValidationFieldResult validationFieldResult;


    @BeforeEach
    void setUp() {
        interactionValidationService = new InteractionValidationService();
        validationFieldResult = new ValidationFieldResult();
    }

    @ParameterizedTest
    @ValueSource(strings = {"tomaten_city_map_one", "city_market_mountain_map_two", "market_map_three"})
    void validateMapInputValid(String map) {
        Enum<InteractionValidationStatus> actualValue = interactionValidationService.validateMapInput(map).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tomaten_city_map_one", "dragon map three", "not_valid_map"})
    void validateMapInputInvalid(String map) {
        Enum<InteractionValidationStatus> actualValue = interactionValidationService.validateMapInput(map).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rionnagen", "Mountain Great", "Malaiche"})
    void validateAreaInputValid(String area) {
        Enum<InteractionValidationStatus> actualValue = interactionValidationService.validateAreaInput(area).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"rionnagen", "Mountain_Great", "Malaiche_map", "Mountain great"})
    void validateAreaInputInvalid(String area) {
        Enum<InteractionValidationStatus> actualValue = interactionValidationService.validateAreaInput(area).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test.txt.py", "sign_interaction.py"})
    void validateFileNameInputValid(String filename) {
        Enum<InteractionValidationStatus> actualValue = interactionValidationService.validateFileNameInput(filename).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Interaction.py", "treausre.pys", "tomate py", "tabuli.tx"})
    void validateFileNameInputInvalid(String filename) {
        Enum<InteractionValidationStatus> actualValue = interactionValidationService.validateFileNameInput(filename).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }
}