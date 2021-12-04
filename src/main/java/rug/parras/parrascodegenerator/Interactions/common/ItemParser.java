package rug.parras.parrascodegenerator.Interactions.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ItemParser {

    public static String convertInputToMethodItemName(String item) {
        return "RECEIVE_".concat(item.toUpperCase());
    }
    public static String convertInputToSuperItemListName(String item) {
        return String.join("_", item.split(" "));
    }
    public static String convertInputToSuperItemListString(String item) {
        return Arrays.stream(item.split(" ")).map(x -> StringUtils.capitalize(x.toLowerCase())).collect(Collectors.joining(" "));
    }

}
