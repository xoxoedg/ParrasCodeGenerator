package rug.parras.parrascodegenerator.Map.Validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rug.parras.parrascodegenerator.Map.Map;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

class MapValidationServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"python.py", "sddasnda.py", "PYthon.py", "JKDLSAKLDLKS.py", "python_test_FILE.py"})
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
    @ValueSource(strings = {"pythonpy", "sddasnda.txt", "testfilE.xd"})
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
    @ValueSource(strings = {"rionnagen_map_entry", "SEAN_Entry_dungeon", "Map_left_right_ENTRY", "Forest_ghost"})
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
    @ValueSource(strings = {"Rionna?gen_map", "testmap32", "WUFFMAP.map", "r/ionnagen_forest"})
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
    @ValueSource(strings = {"0", "10", "30000000", "-1", "-500", "LEFT_EDGE", "RIGHT_EDGE", "BOTTOM", "TOP",
            "left_edge", "right_edge", "bottom", "top", "right_EDGE", "boTTom", "ToP"})
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
    @ValueSource(strings = {"/", "lefft_edge", "Down", "right edge", "left edge" })
    void validateInputInvalidCoordinatesY(String y) {
        Map map = new Map();
        map.setFilename("test.py");
        map.setXCoordinate("5");
        map.setYCoordinate(y);
        map.setMapName("rionnagen_map");

        Enum<ValidationStatus> expectedValidationStatus = ValidationStatus.ERROR;
        Enum<ValidationStatus> actualValidationStatus = new MapValidationService().validateInput(map).getValidationStatus();

        assertSame(expectedValidationStatus, actualValidationStatus);
    }
}