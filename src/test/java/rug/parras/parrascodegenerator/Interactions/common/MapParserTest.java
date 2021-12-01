package rug.parras.parrascodegenerator.Interactions.common;

import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.Treasure;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapParserTest {

    @Test
    void convertInputToMapName() {
        Sign sign = new Sign();
        sign.setMap("city_market_map");
        String actualMapName = MapParser.convertInputToMapName(sign.getMap());
        String expectedMapName = "CityMarketMap";
        assertEquals(expectedMapName,actualMapName);
    }
}