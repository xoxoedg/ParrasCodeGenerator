package rug.parras.parrascodegenerator.Map;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class MapComponentGenerator {

    private final String TILE_MAP_TEMPLATE =
            "%s = [\n" +
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
                    "]";

    public static final String IMPORT_TEMPLATE =
            "from characters.sprites.hero import EscapeCoordinates\n" +
                    "from common.maps.abstract_map import AbstractMap\n" +
                    "from common.sprites.ground import *";

    private final String CLASS_TEMPLATE =
            "class %s(AbstractMap):\n" +
                    "\n" +
                    "    def create_sprites(self, game, col, j, i, initial_hero):\n" +
                    "        Marsh(game, j, i)\n" +
                    "        if self.hero_from_loaded_game(initial_hero):\n" +
                    "            self.place_hero_on_map(game, initial_hero, j, i, EscapeCoordinates(%s, %s))";



    public String generateTileMapList(Map map) {
        return String.format(TILE_MAP_TEMPLATE, map.getMapName().toUpperCase());
    }

    public String generateClass(Map map) {
        return String.format(CLASS_TEMPLATE, StringOperationUtils.convertUnderscoreToCamelCase(map.getMapName()), map.getXCoordinate(), map.getYCoordinate());
    }

}
