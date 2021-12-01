package rug.parras.parrascodegenerator.Interactions.common;

import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.Treasure;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapParserTest {
    private final String expectedMapName = "CityMarketMap";

    @Test
    void convertSignInputToMapName() {
        Sign sign = new Sign();
        sign.setMap("city_market_map");
        String actualMapName = MapParser.convertInputToMapName(sign.getMap());
        assertEquals(expectedMapName,actualMapName);
    }

    @Test
    void ConvertTreasureInputToMapName() {
        Treasure treasure = new Treasure();
        treasure.setMap("city_market_map");
        String actualMapName = MapParser.convertInputToMapName(treasure.getMap());
        assertEquals(expectedMapName, actualMapName);
    }
}