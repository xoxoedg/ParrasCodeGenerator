package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Interactions.common.ValidationStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

class TreasureInteractionValidationServiceTest {

    TreasureInteractionValidationService treasureInteractionValidationService;
    Treasure treasure;
    private final List<String> validItems = List.of("Potion", "potion", "Ether", "ether",
            "Serum", "serum", "Herb", "herb", "Tent", "tent",
            "Super Potion", "super potion", "Super Ether", "super ether");


    @BeforeEach
    void setUp() {
        treasureInteractionValidationService = new TreasureInteractionValidationService();
        treasure = new Treasure();
    }

    @Test
    void validateItemValid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion", "serum");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateItem(testItem).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateItemInvalid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion", "Tomate");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateItem(testItem).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }


    @Test
    void validateAmountValid() {
        List<String> testAmountValid = List.of("3", "4", "8", "7");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateAmount(testAmountValid).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateAmountInvalid1() {
        List<String> testAmountValid = List.of("3", "4", "8", "10");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateAmount(testAmountValid).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateAmountInvalid2() {
        List<String> testAmountValid = List.of("3", "4", "8", "a");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateAmount(testAmountValid).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateInputValid() {
        treasure.setMap("city_market_map_one");
        treasure.setArea("Rionnagen");
        treasure.setFileName("test_file.py");
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(4);

        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateInputInvalid() {
        treasure.setMap("city_market_map_one");
        treasure.setArea("Rionnagen mountain");
        treasure.setFileName("test_file.py");
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(4);

        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;

        assertSame(expectedValue, actualValue);
    }
}