package rug.parras.parrascodegenerator.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapComponentGeneratorTest {

    private MapComponentGenerator mapComponentGenerator;
    private Map map;

    @BeforeEach
    void setUp() {
        mapComponentGenerator = new MapComponentGenerator();
        map = new Map();
        map.setMapName("teSt_wuFf_map");
        map.setYCoordinate(5);
        map.setXCoordinate(5);

    }

    @Test
    void generateTileMapList() {
        String expectedTilemap =
                "TEST_WUFF_MAP = [\n" +
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

        String actualTilemap =  mapComponentGenerator.generateTileMapList(map);
        assertEquals(expectedTilemap, actualTilemap);

    }

    @Test
    void generateClass() {
        String expectedClass =
                "class TestWuffMap(AbstractMap):\n" +
                        "\n" +
                        "    def create_sprites(self, game, col, j, i, initial_hero):\n" +
                        "        Marsh(game, j, i)\n" +
                        "        if self.hero_from_loaded_game(initial_hero):\n" +
                        "            self.place_hero_on_map(game, initial_hero, j, i, EscapeCoordinates(5, 5))";


        String actualClass = mapComponentGenerator.generateClass(map);
        assertEquals(expectedClass, actualClass);
    }
}