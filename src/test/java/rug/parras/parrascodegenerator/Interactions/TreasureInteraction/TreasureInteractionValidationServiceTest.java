package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;

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
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateItem(testItem).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateItemInvalid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion", "Tomate");
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateItem(testItem).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }


    @Test
    void validateAmountValid() {
        List<String> testAmountValid = List.of("3", "4", "8", "7");
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateItemAmount(testAmountValid).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateAmountInvalid1() {
        List<String> testAmountValid = List.of("3", "4", "8", "10");
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateItemAmount(testAmountValid).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateAmountInvalid2() {
        List<String> testAmountValid = List.of("3", "4", "8", "a");
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateItemAmount(testAmountValid).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
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


        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 123, 9999})
    void validateInputInvalid(int ints) {
        treasure.setMap("city_market_map_one");
        treasure.setArea("Rionnagen mountain"); // Invalid
        treasure.setFileName("test_file.py");
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(4);
        treasure.setAmountGold(ints);

        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;

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

        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;

        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateInputValidGoldZero() {
        treasure.setMap("city_market_map_one");
        treasure.setArea("Rionnagen");
        treasure.setFileName("test_file.py");
        treasure.setItemOneName("Tent");
        treasure.setItemOneAmount(4);

        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateInput(treasure).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;

        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateQuantityOfItemsValid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion", "Tent");
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateQuantityOfItems(testItem).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }

    @Test
    void validateQuantityOfItemsInvalid() {
        List<String> testItem = List.of("Tent", "Potion", "Super Potion");
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateQuantityOfItems(testItem).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 4, 10, 999, 9999})
    void validateGoldAmountValid(int gold) {
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateGoldAmount(gold).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.SUCCESS;
        assertSame(expectedValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 383123})
    void validateGoldAmountNotValid(int gold) {
        Enum<InteractionValidationStatus> actualValue = treasureInteractionValidationService.validateGoldAmount(gold).getInteractionValidationStatus();
        Enum<InteractionValidationStatus> expectedValue = InteractionValidationStatus.ERROR;
        assertSame(expectedValue, actualValue);
    }
}