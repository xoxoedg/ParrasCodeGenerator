package rug.parras.parrascodegenerator.Utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringOperationUtilsTest {

    @Test
    void convertUnderscoreToCamelCaseOne() {
        String expectedValue = "HogwartsMapService";
        String actualValue = StringOperationUtils.convertUnderscoreToCamelCase("hogwarts_map_service");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void convertUnderscoreToCamelCaseTwo() {
        String expectedValue = "Wuff";
        String actualValue = StringOperationUtils.convertUnderscoreToCamelCase("wuff");
        assertEquals(expectedValue, actualValue);

    }

    @Test
    void convertSpaceToLowercase() {
        String expectedValue = "wuffmountain";
        String actualValue = StringOperationUtils.convertSpaceToLowercase("wuff Mountain");
        assertEquals(expectedValue, actualValue);
    }
}