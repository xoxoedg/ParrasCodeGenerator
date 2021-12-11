package rug.parras.parrascodegenerator.Interactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationFieldResult;
import rug.parras.parrascodegenerator.common.ValidationStatus;

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
        Enum<ValidationStatus> actualValue = interactionValidationService.validateMapInput(map).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tomaten_city_map_one", "dragon map three", "not_valid_map"})
    void validateMapInputInvalid(String map) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateMapInput(map).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rionnagen", "Mountain Great", "Malaiche"})
    void validateAreaInputValid(String area) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateAreaInput(area).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"rionnagen", "Mountain_Great", "Malaiche_wuff", "Mountain great"})
    void validateAreaInputInvalid(String area) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateAreaInput(area).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"testtxt.py", "sign_interaction.py"})
    void validateFileNameInputValid(String filename) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateFileNameInput(filename).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Interaction.py", "treausre.pys", "tomate py", "tabuli.tx"})
    void validateFileNameInputInvalid(String filename) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateFileNameInput(filename).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }
}