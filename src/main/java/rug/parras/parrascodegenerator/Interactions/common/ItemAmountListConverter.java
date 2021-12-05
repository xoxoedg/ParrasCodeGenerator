package rug.parras.parrascodegenerator.Interactions.common;

import rug.parras.parrascodegenerator.Interactions.TreasureInteraction.Treasure;

import java.util.List;
import java.util.stream.Collectors;
//ToDo Testcases
public class ItemAmountListConverter {

    public static List<String> filterAmount(Treasure treasure) {
        List<Integer> amounts = List.of(treasure.getItemOneAmount(), treasure.getItemTwoAmount(), treasure.getItemThreeAmount());
        return amounts.stream().filter(x -> x != 0).map(String::valueOf).collect(Collectors.toList());
    }

    public static List<String> filterItems(Treasure treasure) {
        List<String> items = List.of(treasure.getItemOneName(), treasure.getItemTwoName(), treasure.getItemThreeName());
        return items.stream().filter(x -> !x.equals("")).map(String::toLowerCase).collect(Collectors.toList());
    }
}
