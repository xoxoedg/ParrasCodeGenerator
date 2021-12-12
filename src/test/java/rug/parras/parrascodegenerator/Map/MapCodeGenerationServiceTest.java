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


    private final String expectedMapCode2 =
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
                    "            self.place_hero_on_map(game, initial_hero, j, i, EscapeCoordinates(LEFT_EDGE, TOP))";




    @Test
    void generateMap() {
        Map map = new Map();
        map.setMapName("Rionnagen_Map");
        map.setXCoordinate("5");
        map.setYCoordinate("10");
        MapComponentGenerator mapComponentGenerator = new MapComponentGenerator();
        MapCodeGenerationService mapCodeGenerationService = new MapCodeGenerationService(mapComponentGenerator);
        String actualMapCode = mapCodeGenerationService.generateMap(map);
        System.out.println(actualMapCode);
        assertEquals(expectedMapCode, actualMapCode);
    }

    @Test
    void generateMap2() {
        Map map = new Map();
        map.setMapName("RiONNAGEN_Map");
        map.setXCoordinate("left_edge");
        map.setYCoordinate("tOp");
        MapComponentGenerator mapComponentGenerator = new MapComponentGenerator();
        MapCodeGenerationService mapCodeGenerationService = new MapCodeGenerationService(mapComponentGenerator);
        String actualMapCode = mapCodeGenerationService.generateMap(map);
        System.out.println(actualMapCode);
        assertEquals(expectedMapCode2, actualMapCode);
    }

}