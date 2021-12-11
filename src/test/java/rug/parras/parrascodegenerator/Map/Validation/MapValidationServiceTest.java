package rug.parras.parrascodegenerator.Map.Validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Map.Map;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

class MapValidationServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"python.py", "sddasnda.py"})
    void validateInputValidFilename(String filename) {
        Map map = new Map();
        map.setFilename(filename);
        map.setXCoordinate("5");
        map.setYCoordinate("5");
        map.setMapName("rionnagen_test_map");

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.SUCCESS;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pythonpy", "sddasnda.txt", "testfilE.py", "Omasdasd.py"})
    void validateInputInvalidFilename(String filename) {
        Map map = new Map();
        map.setFilename(filename);
        map.setXCoordinate("5");
        map.setYCoordinate("5");
        map.setMapName("rionnagen_test_map");

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.ERROR;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }


    @ParameterizedTest
    @ValueSource(strings = {"rionnagen_map", "test_werner_pokemon_map"})
    void validateInputValidMaps(String mapName) {
        Map map = new Map();
        map.setFilename("test.py");
        map.setXCoordinate("5");
        map.setYCoordinate("5");
        map.setMapName(mapName);

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.SUCCESS;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rionnagen_map", "testmap", "WUFFMAP_map", "rionnagen_forest"})
    void validateInputInvalidMaps(String mapName) {
        Map map = new Map();
        map.setFilename("test.py");
        map.setXCoordinate("5");
        map.setYCoordinate("5");
        map.setMapName(mapName);

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.SUCCESS;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "30000000", "-1", "-500"})
    void validateInputValidCoordinatesX(String x) {
        Map map = new Map();
        map.setFilename("test.py");
        map.setXCoordinate(x);
        map.setYCoordinate("5");
        map.setMapName("rionnagen_map");

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.SUCCESS;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "30000000", "-1", "-500"})
    void validateInputValidCoordinatesY(String y) {
        Map map = new Map();
        map.setFilename("test.py");
        map.setXCoordinate("5");
        map.setYCoordinate(y);
        map.setMapName("rionnagen_map");

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.SUCCESS;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }
}