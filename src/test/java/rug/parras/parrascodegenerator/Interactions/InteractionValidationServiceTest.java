package rug.parras.parrascodegenerator.Interactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationService;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationFieldResult;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

class InteractionValidationServiceTest {

    private InteractionValidationService interactionValidationService;
    private ValidationFieldResult validationFieldResult;


    @BeforeEach
    void setUp() {
        interactionValidationService = new InteractionValidationService();
        validationFieldResult = new ValidationFieldResult();
    }

    @ParameterizedTest
    @ValueSource(strings = {"tomaten_city_map_one", "city_market_mountain_map_two", "market_map_three", "market_citty_FOREST", "FOREST_MAP"})
    void validateMapInputValid(String map) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateMapInput(map).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tomaten city_map_one", "dragon map three", "not_valid_map3"})
    void validateMapInputInvalid(String map) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateMapInput(map).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rionnagen", "Mountain Great", "Malaiche", "malaiche FOREST", "forest DEEP WOW"})
    void validateAreaInputValid(String area) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateAreaInput(area).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"rionnagen3", "Mountain  Great", "Malaiche_wuff", "Mountain?great"})
    void validateAreaInputInvalid(String area) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateAreaInput(area).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"testtxt.py", "sign_interaction.py", "WUFFTEST.py"})
    void validateFileNameInputValid(String filename) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateFileNameInput(filename).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Interactionpy", "treausre.pys", "tomate py", "tabuli.tx"})
    void validateFileNameInputInvalid(String filename) {
        Enum<ValidationStatus> actualValue = interactionValidationService.validateFileNameInput(filename).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }
}