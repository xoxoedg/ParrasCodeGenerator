package rug.parras.parrascodegenerator.Area.Validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

class ValidationAreaServiceTest {

    private ValidationAreaService validationAreaService;
    private ValidationAreaResult validationAreaResult;

    @BeforeEach
    void setUp() {
        validationAreaService = new ValidationAreaService();
        validationAreaResult = new ValidationAreaResult();
    }

    @ParameterizedTest
    @ValueSource(strings = {"rionnagen test area", "Rionnagen", "RIONNAGEN FOREST"})
    void validateAreaInputValid(String areaName) {
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        Enum<ValidationStatus> actualValue = validationAreaService.validateAreaInput(areaName).getValidationStatus();
        assertSame(expectedValue, actualValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"rionnagen  test area", "Rionnagen3", "RIONNAGEN_FOREST"})
    void validateAreaInputInvalid(String areaName) {
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        Enum<ValidationStatus> actualValue = validationAreaService.validateAreaInput(areaName).getValidationStatus();
        assertSame(expectedValue, actualValue);

    }
}