package rug.parras.parrascodegenerator.Interactions.common;

public class ItemParser {

    public static String convertInputToMethodItemName(String item) {
        return "RECEIVE_".concat(item.toUpperCase());

    }
}
