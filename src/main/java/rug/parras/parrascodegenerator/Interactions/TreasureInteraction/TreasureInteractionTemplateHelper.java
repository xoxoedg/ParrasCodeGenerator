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
    public static final String METHOD_ARGUMENTS_TEMPLATE ="(timeline, 'RECEIVED_%s_CHEST'%s%s%s%s%s%s%s%s)"; // 9
    public static final String SUPER_FUNCTION_TEMPLATE ="super(%sChestInteraction, self)";
    public static final String RETRIEVE_CHEST_CONTENT_TEMPLATE =
            "def retrieve_chest_content(self, hero):\n" +
                    "    %s" +
                    "    %s\n" +
                    "    %s\n" +
                    "    %s";


    public static final String TREASURE_INTERACTION_LIST_RECEIVE_GOLD_NAME_TEMPLATE =
            "RECEIVE_GOLD_IN_%s";

    public static final String TREASURE_INTERACTION_LIST_ITEM_TEXT_TEMPLATE =
            "['Received %s']";

    public static final String TREASURE_INTERACTION_LIST_GOLD_TEXT_TEMPLATE =
            "['You receive %s gold']";


    public static final String TREASURE_INTERACTION_IMPORT_TEMPLATE =
            "from characters.item_interaction.common.standard_treasure_interaction import StandardTreasureInteraction";


    public List<String> generateItemList(Treasure treasure) {
        List<String> filteredItemsListName = filterItems(treasure);
        return filteredItemsListName.stream().map(x -> ItemParser.convertInputToMethodItemName(x) + " = " +
                String.format(TREASURE_INTERACTION_LIST_ITEM_TEXT_TEMPLATE, StringUtils.capitalize(x))).collect(Collectors.toList());
    }

    public String generateGoldList(Treasure treasure) {
        String listName = String.format(TREASURE_INTERACTION_LIST_RECEIVE_GOLD_NAME_TEMPLATE, MapParser.convertInputToUppercaseMap(treasure.getMap()));
        return listName + " = " + String.format(TREASURE_INTERACTION_LIST_GOLD_TEXT_TEMPLATE, treasure.getAmountGold());
    }

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
        return itemAmountMap.entrySet().stream().map(x -> String.format(ITEM_TEMPLATE, x.getKey(), x.getValue())).map(x -> "\t" + x).collect(Collectors.toList());
    }

    //In Common auslagern oder Utils
    public Map<String, String> convertListToMap(List<String> filteredItems, List<String> filteredAmounts) {
        return IntStream.range(0, filteredItems.size()).boxed().collect(Collectors.toMap(filteredItems::get, filteredAmounts::get));
    }

    public String generateGoldEarned(Treasure treasure) {
        return treasure.getAmountGold() > 0 ? "\t" + String.format(GOLD_TEMPLATE, treasure.getAmountGold()): "";
    }

    public String generateSuperMethod(Treasure treasure) {
        return !treasure.getMap().equals("") ? String.format(SUPER_FUNCTION_TEMPLATE, String.format(MapParser.convertInputToMapName(treasure.getMap()))): "";
    }
}
