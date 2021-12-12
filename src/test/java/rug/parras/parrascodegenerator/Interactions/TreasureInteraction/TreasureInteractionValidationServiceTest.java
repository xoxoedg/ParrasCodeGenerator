package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Interactions.Validation.TreasureInteractionValidationService;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

class TreasureInteractionValidationServiceTest {

    TreasureInteractionValidationService treasureInteractionValidationService;
    Treasure treasure;


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
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateItemAmount(testAmountValid).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateAmountInvalid1() {
        List<String> testAmountValid = List.of("3", "4", "8", "10");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateItemAmount(testAmountValid).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateAmountInvalid2() {
        List<String> testAmountValid = List.of("3", "4", "8", "a");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateItemAmount(testAmountValid).getValidationStatus();
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
        treasure.setAmountGold(5);


        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 123, 9999})
    void validateInputInvalid(int ints) {
        treasure.setMap("city_market_one");
        treasure.setArea("Rionnagen_mountain"); // Invalid
        treasure.setFileName("test_file.py");
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(4);
        treasure.setAmountGold(ints);

        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;

        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tent", "Sword"})
    void validateInputInvalidItemQuantity(String itemTwo) {
        treasure.setMap("city_market_map_one");
        treasure.setArea("Rionnagen"); // Invalid
        treasure.setFileName("test_file.py");
        treasure.setItemOneName("Tent"); //Error
        treasure.setItemOneAmount(4);
        treasure.setItemTwoName("Sword");
        treasure.setItemTwoAmount(2);
        treasure.setItemThreeName(itemTwo);
        treasure.setItemThreeAmount(2);

        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;

        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateInputValidGoldZero() {
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
    void validateQuantityOfItemsValid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion", "Tent");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateQuantityOfItems(testItem).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateQuantityOfItemsInvalid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion");
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateQuantityOfItems(testItem).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 4, 10, 999, 9999})
    void validateGoldAmountValid(int gold) {
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateGoldAmount(gold).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 383123})
    void validateGoldAmountNotValid(int gold) {
        Enum<ValidationStatus> actualValue = treasureInteractionValidationService.validateGoldAmount(gold).getValidationStatus();
        Enum<ValidationStatus> expectedValue = ValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }
}