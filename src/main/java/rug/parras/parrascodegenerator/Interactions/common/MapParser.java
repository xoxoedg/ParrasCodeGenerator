package rug.parras.parrascodegenerator.Interactions.common;

import org.apache.commons.lang3.StringUtils;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;

import java.util.Arrays;
import java.util.stream.Collectors;

public  class MapParser {

    public static String convertInputToMapName(Sign sign) {
        return Arrays.stream(sign.getMap().split("_")).filter(x -> !x.equals("_")).map(StringUtils::capitalize).collect(Collectors.joining(""));
    }
}
