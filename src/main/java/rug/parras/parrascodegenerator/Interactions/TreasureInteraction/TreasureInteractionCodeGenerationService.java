package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;


import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.common.ItemParser;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;
@Service
public class TreasureInteractionCodeGenerationService {

    private TreasureInteractionTemplateHelper treasureInteractionTemplateHelper;

    public String generateTreasureInteractionClass(Treasure treasure) {
        treasureInteractionTemplateHelper = new TreasureInteractionTemplateHelper();
        String receiveGoldArgument = String.format(TreasureInteractionTemplateHelper.TREASURE_INTERACTION_LIST_RECEIVE_GOLD_NAME_TEMPLATE, MapParser.convertInputToUppercaseMap(treasure.getMap()));
        String convertedMapName = MapParser.convertInputToMapName(treasure.getMap());
        String generatedSuperMethod = treasureInteractionTemplateHelper.generateSuperMethod(treasure);
        String generatedGoldList = treasureInteractionTemplateHelper.generateGoldList(treasure);
//        String generatedListItemOne = treasureInteractionTemplateHelper.generateItemList(treasure).get(0);
//        String generatedListItemTwo = treasureInteractionTemplateHelper.generateItemList(treasure).get(1);
//        String generatedListItemThree = treasureInteractionTemplateHelper.generateItemList(treasure).get(2);


        if (treasure.getAmountGold() == 0) {
            switch (treasureInteractionTemplateHelper.filterItems(treasure).size()) {
                case 0:
                    String methodArgumentsZeroItem = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), "", "", "", "", "", "", "", "").trim();
                    String retrieveChestMethodZeroItem = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE, "", "", "", "");
                    String generatedClassZeroItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentsZeroItem, retrieveChestMethodZeroItem);
                    String generatedTreasureInteractionCodeZeroItem = TreasureInteractionTemplateHelper.TREASURE_INTERACTION_IMPORT_TEMPLATE + "\n\n\n" +
                            "\n\n\n" + generatedClassZeroItem;
                    return generatedTreasureInteractionCodeZeroItem;

                case 1:
                    String methodArgumentsOneItem = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(0)), "", "", "", "", "", "").trim();
                    String retrieveChestMethodOneItem = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(0), "", "", "");
                    String generatedClassOneItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentsOneItem, retrieveChestMethodOneItem);
                    String generatedListItemOne = treasureInteractionTemplateHelper.generateItemList(treasure).get(0);
                    String generatedTreasureInteractionCodeOneItem = TreasureInteractionTemplateHelper.TREASURE_INTERACTION_IMPORT_TEMPLATE + "\n\n\n" + generatedListItemOne +
                            "\n" + generatedClassOneItem +
                            "\n\n\n" + generatedClassOneItem;
                    return generatedTreasureInteractionCodeOneItem;
                case 2:
                    String methodArgumentsTwoItem = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(1)),
                            "", "", "", "").trim();
                    String retrieveChestMethodTwoItem = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(0) + "\n",
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(1), "", "");
                    String generatedClassTwoItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName,
                            generatedSuperMethod, methodArgumentsTwoItem, retrieveChestMethodTwoItem);
                    return generatedClassTwoItem;
                case 3:
                    String methodArgumentsThreeItem = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(1)), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(2)), "", "").trim();
                    String retrieveChestMethodThreeItem = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(0),
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(1),
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(2), "");

                    String generatedClassThreeItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentsThreeItem, retrieveChestMethodThreeItem);
                    return generatedClassThreeItem;
                default:
                    return "";
            }
        } else {
            switch (treasureInteractionTemplateHelper.filterItems(treasure).size()) {

                case 0:
                    String methodArgumentZeroItemAndGold = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, "", "", "", "", "", "").trim();
                    String retrieveChestMethodZeroItemAndGold = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.generateGoldEarned(treasure), "", "", "");
                    String generatedClassOZeroItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentZeroItemAndGold ,retrieveChestMethodZeroItemAndGold);
                    return generatedClassOZeroItemAndGold;
                case 1:
                    String methodArgumentOneItemAndGold = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(0)), "", "", "", "").trim();
                    String retrieveChestMethodOneItemAndGold = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.generateGoldEarned(treasure) + "\n",
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(0) + "\n", "", "");
                    String generatedClassOneItemOneItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentOneItemAndGold ,retrieveChestMethodOneItemAndGold);
                    return generatedClassOneItemOneItemAndGold;
                case 2:
                    String methodArgumentTwoItemAndGold = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(1)), "", "").trim();
                    String retrieveChestMethodTwoItemAndGold = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.generateGoldEarned(treasure) + "\n",
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(0),
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(1), "");
                    String generatedClassOneItemTwoItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentTwoItemAndGold, retrieveChestMethodTwoItemAndGold);
                    return generatedClassOneItemTwoItemAndGold;

                case 3:
                    String methodArgumentThreeItemAndGold = String.format(TreasureInteractionTemplateHelper.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                            receiveGoldArgument, ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(0)), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(1)), ", ",
                            ItemParser.convertInputToMethodItemName(treasureInteractionTemplateHelper.filterItems(treasure).get(2))).trim();
                    String retrieveChestMethodThreeItemAndGold = String.format(TreasureInteractionTemplateHelper.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                            treasureInteractionTemplateHelper.generateGoldEarned(treasure) + "\n",
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(0),
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(1),
                            treasureInteractionTemplateHelper.convertItemAmountMapToFinalTemplateList(treasure).get(2));
                    String generatedClassOneItemThreeItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentThreeItemAndGold,retrieveChestMethodThreeItemAndGold);
                    return generatedClassOneItemThreeItemAndGold;
                    default:
                    return "";
            }
        }
    }
}
