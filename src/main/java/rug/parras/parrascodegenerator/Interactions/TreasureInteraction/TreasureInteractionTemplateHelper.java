package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.apache.commons.lang3.StringUtils;
import rug.parras.parrascodegenerator.Interactions.common.ItemParser;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreasureInteractionTemplateHelper {


    public static final String ITEM_TEMPLATE = "hero.items.%s.amount += %s";
    public static final String GOLD_TEMPLATE = "hero.gold += %s";
    public static final String METHOD_ARGUMENTS_TEMPLATE ="(timeline, 'RECEIVED_%s_CHEST%s%s%s%s%s%s%s%s)"; // 9
    public static final String SUPER_FUNCTION_TEMPLATE ="super(%sChestInteraction, self)";
    public static final String RETRIEVE_CHEST_CONTENT_TEMPLATE =
            "def retrieve_chest_content(self, hero):\n" +
                    "    %s" +
                    "    %s\n" +
                    "    %s\n" +
                    "    %s";


    public List<String> filterAmount(Treasure treasure) {
        List<Integer> amounts = List.of(treasure.getItemOneAmount(), treasure.getItemTwoAmount(),treasure.getItemThreeAmount());
        return amounts.stream().filter(x -> x != 0).map(String::valueOf).collect(Collectors.toList());
    }

    public List<String> filterItems(Treasure treasure) {
        List<String> items = List.of(treasure.getItemOneName(), treasure.getItemTwoName(), treasure.getItemThreeName());
        return items.stream().filter(x -> !x.equals("")).map(String::toLowerCase).collect(Collectors.toList());
    }

    public List<String> convertItemAmountMapToFinalTemplateList(Treasure treasure) {
        Map<String, String> itemAmountMap = convertListToMap(filterItems(treasure), filterAmount(treasure));
        System.out.println(itemAmountMap);
        return itemAmountMap.entrySet().stream().map(x -> String.format(ITEM_TEMPLATE, x.getKey(), x.getValue())).map(x -> "\t" + x).collect(Collectors.toList());
    }

    //In Common auslagern oder Utils
    public Map<String, String> convertListToMap(List<String> filteredItems, List<String> filteredAmounts) {
        return IntStream.range(0, filteredItems.size()).boxed().collect(Collectors.toMap(filteredItems::get, filteredAmounts::get));
    }

    public String generateFunctionArguments(Treasure treasure) {
        String receiveGoldArgument = String.format(Treasure.TREASURE_INTERACTION_LIST_ITEM_NAME_TEMPLATE, MapParser.convertInputToUppercaseMap(treasure.getMap()));
        if (treasure.getAmountGold() == 0) {
            switch (filterItems(treasure).size()) {
                case 0:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), "", "", "", "", "", "", "", "").trim();
                case 1:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(0)), "", "", "", "", "", "").trim();
                case 2:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(1)),
                            "", "", "", "").trim();
                case 3:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(1)), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(2)), "", "").trim();
                default:
                    return "";
            }
        } else {
            switch (filterItems(treasure).size()) {
                case 0:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, "", "", "", "", "", "").trim();
                case 1:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(0)), "", "", "", "").trim();
                case 2:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(1)), "", "").trim();
                case 3:
                    return String.format(METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(1)), ", ",
                            ItemParser.convertInputToMethodItemName(filterItems(treasure).get(2))).trim();
                default:
                    return "";
            }
        }
    }

    public String generateRetrieveChestMethod(Treasure treasure) {
        if (treasure.getAmountGold() == 0) {
            switch (filterItems(treasure).size()) {
                case 0:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE, "", "", "", "");
                case 1:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            convertItemAmountMapToFinalTemplateList(treasure).get(0), "", "", "");
                case 2:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            convertItemAmountMapToFinalTemplateList(treasure).get(0) + "\n",
                            convertItemAmountMapToFinalTemplateList(treasure).get(1), "", "");
                case 3:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            convertItemAmountMapToFinalTemplateList(treasure).get(0),
                            convertItemAmountMapToFinalTemplateList(treasure).get(1),
                            convertItemAmountMapToFinalTemplateList(treasure).get(2),
                            "");
                default:
                    return "";
            }
        } else {
            switch (filterItems(treasure).size()) {
                case 0:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            generateGoldEarned(treasure), "", "", "");
                case 1:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            generateGoldEarned(treasure) + "\n",
                            convertItemAmountMapToFinalTemplateList(treasure).get(0) + "\n", "", "");
                case 2:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            generateGoldEarned(treasure) + "\n",
                            convertItemAmountMapToFinalTemplateList(treasure).get(0),
                            convertItemAmountMapToFinalTemplateList(treasure).get(1), "");
                case 3:
                    return String.format(RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            generateGoldEarned(treasure) + "\n",
                            convertItemAmountMapToFinalTemplateList(treasure).get(0),
                            convertItemAmountMapToFinalTemplateList(treasure).get(1), convertItemAmountMapToFinalTemplateList(treasure).get(2));
                default:
                    return "";
            }
        }
    }



    public String generateGoldEarned(Treasure treasure) {
        return treasure.getAmountGold() > 0 ? "\t" + String.format(GOLD_TEMPLATE, treasure.getAmountGold()): "";
    }

    public String generateSuperMethod(Treasure treasure) {
        return !treasure.getMap().equals("") ? String.format(SUPER_FUNCTION_TEMPLATE, String.format(MapParser.convertInputToMapName(treasure.getMap()))): "";
    }

}
