package rug.parras.parrascodegenerator.Interactions.common;

import org.apache.commons.lang3.StringUtils;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.Treasure;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public  class MapParser {

    public static String convertInputToMapName(String map) {
        return Arrays.stream(map.split("_")).filter(x -> !x.equals("_")).map(x -> StringUtils.capitalize(x.toLowerCase())).collect(Collectors.joining(""));
    }

    public static String convertInputToUppercaseMap(String map) {
        return map.toUpperCase();
    }
}
