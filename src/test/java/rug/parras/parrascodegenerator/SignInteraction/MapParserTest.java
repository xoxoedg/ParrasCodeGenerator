package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapParserTest {

    @Test
    void convertInputToClassName() {
        String inputMapName = "close_to_lake_balgon_map";
        String convertedMapName = "CloseToLakeBalgonMap";
        assertEquals(convertedMapName, MapParser.convertInputToMapName(Sign.builder().map(inputMapName).build()));
    }
}