package rug.parras.parrascodegenerator.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapCodeGenerationServiceTest {

    private final String expectedMapCode =
        "from characters.sprites.hero import EscapeCoordinates\n" +
                "from common.maps.abstract_map import AbstractMap\n" +
                "from common.sprites.ground import *\n" +
                "\n" +
                "RIONNAGEN_MAP = [\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "    '....................',\n" +
                "]\n" +
                "\n" +
                "\n" +
                "class RionnagenMap(AbstractMap):\n" +
                "\n" +
                "    def create_sprites(self, game, col, j, i, initial_hero):\n" +
                "        Marsh(game, j, i)\n" +
                "        if self.hero_from_loaded_game(initial_hero):\n" +
                "            self.place_hero_on_map(game, initial_hero, j, i, EscapeCoordinates(5, 10))";


    @Test
    void generateMap() {
        Map map = new Map();
        map.setMapName("Rionnagen");
        map.setXCoordinate(5);
        map.setYCoordinate(10);
        MapComponentGenerator mapComponentGenerator = new MapComponentGenerator();
        MapCodeGenerationService mapCodeGenerationService = new MapCodeGenerationService(mapComponentGenerator);
        String actualMapCode = mapCodeGenerationService.generateMap(map);
        System.out.println(actualMapCode);
        assertEquals(expectedMapCode, actualMapCode);
    }
}