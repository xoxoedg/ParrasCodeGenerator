package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import java.util.HashMap;
import java.util.List;

public class TreasureInteractionItemMapper {


    public List<HashMap<String, Integer>> makeList(Treasure treasure) {
        HashMap<String, Integer> itemOneMap = new HashMap<>();
        itemOneMap.put(treasure.getItemOneName(), treasure.getItemOneAmount());
        HashMap<String, Integer> itemTwoMap = new HashMap<>();
        itemOneMap.put(treasure.getItemTwoName(), treasure.getItemTwoAmount());
        HashMap<String, Integer> itemThreeMap = new HashMap<>();
        itemOneMap.put(treasure.getItemThreeName(), treasure.getItemThreeAmount());
        List<HashMap<String, Integer>> mappedTreasureItems = List.of(itemOneMap, itemTwoMap, itemThreeMap);

        return mappedTreasureItems;
    }
}
