package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapParserTest {
    private String inputMapName;
    private String convertedMapName;

    @Test
    void convertInputToClassName() {
        inputMapName = "close_to_lake_balgon_map";
        convertedMapName = "CloseToLakeBalgonMap";
        assertEquals(convertedMapName, MapParser.convertInputToClassName(Sign.builder().map(inputMapName).build()));
    }
}