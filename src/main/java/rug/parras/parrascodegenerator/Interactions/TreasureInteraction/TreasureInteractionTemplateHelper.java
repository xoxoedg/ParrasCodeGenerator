package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreasureInteractionTemplateHelper {


    public static final String ITEM_TEMPLATE = "hero.items.%s.amount += %s";
    public static final String GOLD_TEMPLATE = "hero.gold += %s";
    public static final String FUNCTION_ARGUMENTS_TEMPLATE ="(timeline, 'RECEIVED_%s_CHEST%s%s%s%s%s%s%s%s)"; // 9
    public static final String SUPER_FUNCTION_TEMPLATE ="super(%sChestInteraction, self)";

    public List<String> filterAmount(Treasure treasure) {
        List<Integer> amounts = List.of(treasure.getItemOneAmount(), treasure.getItemTwoAmount(),treasure.getItemThreeAmount());
        return amounts.stream().filter(x -> x != 0).map(String::valueOf).collect(Collectors.toList());
    }

    public List<String> filterItems(Treasure treasure) {
        List<String> items = List.of(treasure.getItemOneName(), treasure.getItemTwoName(), treasure.getItemThreeName());
        return items.stream().filter(x -> !x.equals("")).collect(Collectors.toList());
    }

    public List<String> convertMapToFinalTemplateList(Treasure treasure) {
        Map<String, String> itemAmountMap = listToMapConverter(filterItems(treasure), filterAmount(treasure));
        System.out.println(itemAmountMap);
        return itemAmountMap.entrySet().stream().map(x -> String.format(ITEM_TEMPLATE, x.getKey(), x.getValue())).collect(Collectors.toList());
    }

    //In Common auslagern oder Utils
    public Map<String, String> listToMapConverter(List<String> filteredItems, List<String> filteredAmounts) {
        return IntStream.range(0, filteredItems.size()).boxed().collect(Collectors.toMap(filteredItems::get, filteredAmounts::get));
    }

    public String generateFunctionArguments(Treasure treasure) {
        if (treasure.getAmountGold() == 0) {
            switch (filterItems(treasure).size()) {
                case 0:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), "", "", "", "", "", "", "", "");
                case 1:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), ", ", filterItems(treasure).get(0),"", "", "", "", "", "");
                case 2:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), filterItems(treasure).get(0), filterItems(treasure).get(1),
                            "", "", "", "", "", "", "");
                case 3:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), filterItems(treasure).get(0), filterItems(treasure).get(1),
                            filterItems(treasure).get(2), "", "", "", "", "");
                default:
                    return "";
            }
        } else {
            switch (filterItems(treasure).size()) {
                case 0:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), treasure.getAmountGold(), "", "", "", "", "", "", "");
                case 1:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), treasure.getAmountGold(), filterItems(treasure).get(0), "", "", "", "", "", "");
                case 2:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), treasure.getAmountGold(), filterItems(treasure).get(0), filterItems(treasure).get(1),
                            "", "", "", "", "");
                case 3:
                    return String.format(FUNCTION_ARGUMENTS_TEMPLATE, treasure.getMap(), treasure.getAmountGold(), filterItems(treasure).get(0), filterItems(treasure).get(1),
                            filterItems(treasure).get(2), "", "", "", "");
                default:
                    return "";
            }

        }
    }
//    public String generateItemTemplate () {
//
//    }
}
