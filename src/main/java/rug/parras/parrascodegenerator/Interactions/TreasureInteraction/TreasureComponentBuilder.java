package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class TreasureComponentBuilder {

    public static final String TIMELINE_METHOD_STRING_TEMPLATE = "RECEIVED_CHEST_";
    public static final String GOLD_TEMPLATE = "hero.gold += %s";
    public static final String CONSTRUCTOR_METHOD_ARGUMENTS_TEMPLATE = "(timeline";
    public static final String SUPER_METHOD_TEMPLATE = "super";
    public static final String SUPER_METHOD_ARGUMENTS = "(ChestInteraction, self)";
    public static final String CLASS_CONSTRUCTOR_TEMPLATE = "def __init__(self, timeline):\n";
    public static final String INNIT_TEMPLATE = ".__init__.";
    public static final String REWARD_LIST_STRING_TEMPLATE = "Received ";
    public static final String ITEM_FINDER_STRING_TEMPLATE = "ItemFinder.add_to_items";


    public static final String RETRIEVE_CHEST_CONTENT_TEMPLATE =
            "def retrieve_chest_content(self, hero):\n";

    public static final String TREASURE_INTERACTION_IMPORT_TEMPLATE =
            "from characters.item_interaction.common.standard_treasure_interaction import StandardTreasureInteraction";

    public static final String CLASS_NAME_TEMPLATE = "class %sChestInteraction(StandardTreasureInteraction):\n";

    public String generateTreasureInteraction(Treasure treasure) {
        StringBuilder generatedTreasureInteraction = new StringBuilder();
        List<String> treasureInteractionComponents = List.of(TREASURE_INTERACTION_IMPORT_TEMPLATE + "\n\n" ,generateRewardList(treasure) + "\n\n", generateClassName(treasure) + "\n\n",
                "\t" + generateClassConstructor(treasure) + "\n\n" + "\t" + generateRetrieveChestMethod(treasure));
        treasureInteractionComponents.forEach(generatedTreasureInteraction::append);
        return generatedTreasureInteraction.toString();
    }

    public String generateClassName(Treasure treasure) {
        return  String.format(CLASS_NAME_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()));
    }

    public String generateClassConstructor(Treasure treasure) {
        StringBuilder generatedClassConstructors = new StringBuilder();
        List<String> classConstructorComponents = List.of(CLASS_CONSTRUCTOR_TEMPLATE, "\t\t" + generateSuperMethod(treasure),
                INNIT_TEMPLATE, generateConstructorArguments(treasure));

        classConstructorComponents.forEach(generatedClassConstructors::append);
        return generatedClassConstructors.toString();
    }

    public String generateConstructorArguments(Treasure treasure) {
        StringBuilder generatedConstructorArguments = new StringBuilder();
        List<String> constructorArgumentsComponents = List.of(CONSTRUCTOR_METHOD_ARGUMENTS_TEMPLATE, generateTimeLineString(treasure), generateRewardsListName(treasure), ")");
        constructorArgumentsComponents.stream().map(x -> !constructorArgumentsComponents.get(0).equals(x) &&
                !constructorArgumentsComponents.get(constructorArgumentsComponents.size() -1 ).equals(x)? ", " + x: x )
                .forEach(generatedConstructorArguments::append);
        return generatedConstructorArguments.toString();
    }

    public String generateSuperMethod(Treasure treasure) {
        StringBuilder generatedSuperMethod = new StringBuilder();
        List<String> superMethodComponents = List.of(SUPER_METHOD_TEMPLATE, generateSuperMethodArguments(treasure));
        superMethodComponents.forEach(generatedSuperMethod::append);
        return !treasure.getMap().equals("") ? generatedSuperMethod.toString() : "";
    }

    public String generateSuperMethodArguments(Treasure treasure) {
        StringBuilder generatedSuperMethod = new StringBuilder();
        generatedSuperMethod.append(SUPER_METHOD_ARGUMENTS).insert(1, MapParser.convertInputToMapName(treasure.getMap()));
        return generatedSuperMethod.toString();
    }

    public String generateTimeLineString(Treasure treasure) {
        StringBuilder generatedTimeLineString = new StringBuilder();
        List<String> timeLineStringComponents = List.of(TIMELINE_METHOD_STRING_TEMPLATE, treasure.getMap().toUpperCase());
        timeLineStringComponents.forEach(generatedTimeLineString::append);
        return "'" + generatedTimeLineString + "'";
    }

    public String generateRetrieveChestMethod(Treasure treasure) {
        StringBuilder generatedRetrieveChestMethod = new StringBuilder();
        List<String> retrieveChestMethodComponents = List.of(RETRIEVE_CHEST_CONTENT_TEMPLATE, generateItemFinderMethod(treasure), generateGoldEarned(treasure));
        retrieveChestMethodComponents.forEach(generatedRetrieveChestMethod::append);
        return generatedRetrieveChestMethod.toString();
    }

    public String generateItemFinderMethod(Treasure treasure) {
        StringBuilder generatedItemFinderMethod = new StringBuilder();
        List<String> generatedItemFinderComponents = generateItemFinderArguments(treasure);
        generatedItemFinderComponents.stream().map(x -> !x.equals(generatedItemFinderComponents
                .get(generatedItemFinderComponents.size() - 1)) ? "\t\t" + ITEM_FINDER_STRING_TEMPLATE + x +"\n":"\t\t" + ITEM_FINDER_STRING_TEMPLATE + x )
                .forEach(generatedItemFinderMethod::append);
        return generatedItemFinderMethod.toString();
    }
    public List<String> generateItemFinderArguments(Treasure treasure) {
        Map<String, String> itemAmountMap = convertListToMap(filterItems(treasure), filterAmount(treasure));
        List<String> itemFinderArgumentsComponents = new ArrayList<>();
        itemAmountMap.forEach((key, value) -> itemFinderArgumentsComponents.add("(hero" + ", " + key + ", " + value + ")"));
        return itemFinderArgumentsComponents;
    }

    public String generateGoldEarned(Treasure treasure) {
        return  treasure.getAmountGold() > 0 ? "\n\t\t" + String.format(GOLD_TEMPLATE, treasure.getAmountGold()) : "";
    }

    public String generateRewardList(Treasure treasure) {
        StringBuilder generatedRewardList = new StringBuilder();
        List<String> rewardListComponents = List.of(generateRewardsListName(treasure), " = " + generateListMessage(treasure));
        rewardListComponents.forEach(generatedRewardList::append);
        return generatedRewardList.toString();
    }

    public String generateRewardsListName(Treasure treasure) {
        StringBuilder generatedRewardsList = new StringBuilder();
        List<String> rewardsListTemplateComponent;
        List<String> rewardsItemComponents = filterItems(treasure);
        if (treasure.getAmountGold() > 0) {
            rewardsListTemplateComponent = List.of("Receive", "Gold");

        } else {
            rewardsListTemplateComponent = List.of("Receive");
        }
        List<String> rewardListNameComponents = Stream.concat(rewardsListTemplateComponent.stream(), rewardsItemComponents.stream())
                .collect(Collectors.toList());
        rewardListNameComponents.stream()
                .map(x -> !x.equals(rewardListNameComponents
                        .get(rewardListNameComponents.size() - 1)) ? x + "_" : x)
                .forEach(generatedRewardsList::append);
        return generatedRewardsList.toString().toUpperCase();
    }

    public String generateListMessage(Treasure treasure) {
        StringBuilder generatedListMessage = new StringBuilder();
        List<String> listMessageComponents = new ArrayList<>();
        List<String> itemRewards = filterItems(treasure);
        generatedListMessage.append(REWARD_LIST_STRING_TEMPLATE); // [Gold]
        String rewardGoldText = treasure.getAmountGold() + " Gold";
        if (treasure.getAmountGold() > 0 && itemRewards.size() == 0 ) {
            listMessageComponents.add(rewardGoldText);
        } else if (treasure.getAmountGold() == 0 && itemRewards.size() > 0){
            listMessageComponents.addAll(itemRewards);
        } else if (treasure.getAmountGold() > 0 && itemRewards.size() > 0) {
            listMessageComponents.add(rewardGoldText);
            listMessageComponents.addAll(itemRewards);
        } else
            return "Sorry you have to atleast reward the player with gold or one item";
        listMessageComponents.stream().map(x -> listMessageComponents.size() < 2 && x.equals(listMessageComponents.get(0))
                || x.equals(listMessageComponents.get(listMessageComponents.size() - 1))
       ? StringUtils.capitalize(x) : StringUtils.capitalize(x) + " and ").forEach(generatedListMessage::append);
        return "['" + generatedListMessage + "']";
    }

    //Auslagern
    public List<String> filterAmount(Treasure treasure) {
        List<Integer> amounts = List.of(treasure.getItemOneAmount(), treasure.getItemTwoAmount(), treasure.getItemThreeAmount());
        return amounts.stream().filter(x -> x != 0).map(String::valueOf).collect(Collectors.toList());
    }
    public List<String> filterItems(Treasure treasure) {
        List<String> items = List.of(treasure.getItemOneName(), treasure.getItemTwoName(), treasure.getItemThreeName());
        return items.stream().filter(x -> !x.equals("")).map(String::toLowerCase).collect(Collectors.toList());
    }

    public Map<String, String> convertListToMap(List<String> filteredItems, List<String> filteredAmounts) {
        return IntStream.range(0, filteredItems.size()).boxed().collect(Collectors.toMap(filteredItems::get, filteredAmounts::get));
    }
}
