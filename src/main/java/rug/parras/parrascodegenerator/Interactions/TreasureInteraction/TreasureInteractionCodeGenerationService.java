package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;


import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.common.ItemParser;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;

@Service
public class TreasureInteractionCodeGenerationService {

    private TreasureInteractionComponentGenerator treasureInteractionComponentGenerator;

    public String generateTreasureInteractionForThreeItemsAndGold(Treasure treasure, String receiveGoldArgument, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentThreeItemAndGold = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                receiveGoldArgument, ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(0)), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(1)), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(2))).trim();
        String retrieveChestMethodThreeItemAndGold = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.generateGoldEarned(treasure) + "\n",
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(0),
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(1),
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(2));
        String generatedClassOneItemThreeItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentThreeItemAndGold,retrieveChestMethodThreeItemAndGold);
        return generatedClassOneItemThreeItemAndGold;
    }

    public String generateTreasureInteractionForTwoItemsAndGold(Treasure treasure, String receiveGoldArgument, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentTwoItemAndGold = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                receiveGoldArgument, ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(0)), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(1)), "", "").trim();
        String retrieveChestMethodTwoItemAndGold = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.generateGoldEarned(treasure) + "\n",
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(0),
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(1), "");
        String generatedClassOneItemTwoItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentTwoItemAndGold, retrieveChestMethodTwoItemAndGold);
        return generatedClassOneItemTwoItemAndGold;
    }

    public String generateTreasureInteractionCodeForOneItemsAndGold(Treasure treasure, String receiveGoldArgument, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentOneItemAndGold = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                receiveGoldArgument, ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(0)), "", "", "", "").trim();
        String retrieveChestMethodOneItemAndGold = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.generateGoldEarned(treasure) + "\n",
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(0) + "\n", "", "");
        String generatedClassOneItemOneItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentOneItemAndGold ,retrieveChestMethodOneItemAndGold);
        return generatedClassOneItemOneItemAndGold;
    }

    public String generateTreasureInteractionCodeForZeroItemsAndGold(Treasure treasure, String receiveGoldArgument, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentZeroItemAndGold = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                receiveGoldArgument, "", "", "", "", "", "").trim();
        String retrieveChestMethodZeroItemAndGold = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.generateGoldEarned(treasure), "", "", "");
        String generatedClassOZeroItemAndGold = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentZeroItemAndGold ,retrieveChestMethodZeroItemAndGold);
        return generatedClassOZeroItemAndGold;
    }

    public String generateTreasureInteractionCodeForThreeItems(Treasure treasure, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentsThreeItem = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(0)), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(1)), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(2)), "", "").trim();
        String retrieveChestMethodThreeItem = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(0),
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(1),
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(2), "");

        String generatedClassThreeItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentsThreeItem, retrieveChestMethodThreeItem);
        return generatedClassThreeItem;
    }

    public String generateTreasureInteractionCodeForTwoItem(Treasure treasure, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentsTwoItem = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), ", ",
               ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(0)), ", ",
               ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(1)),
               "", "", "", "").trim();
        String retrieveChestMethodTwoItem = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(0) + "\n",
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(1), "", "");
        String generatedClassTwoItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName,
                generatedSuperMethod, methodArgumentsTwoItem, retrieveChestMethodTwoItem);
        String generatedListItemOne = treasureInteractionComponentGenerator.generateItemList(treasure).get(0);
        String generatedListItemTwo = treasureInteractionComponentGenerator.generateItemList(treasure).get(1);
        return generatedClassTwoItem;
    }

    public String generateTreasureInteractionCodeForOneItem(Treasure treasure, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentsOneItem = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, treasure.getMap().toUpperCase(), ", ",
                ItemParser.convertInputToMethodItemName(treasureInteractionComponentGenerator.filterItems(treasure).get(0)), "", "", "", "", "", "").trim();
        String retrieveChestMethodOneItem = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE,
                treasureInteractionComponentGenerator.convertItemAmountMapToFinalTemplateList(treasure).get(0), "", "", "");
        String generatedClassOneItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName,
                generatedSuperMethod, methodArgumentsOneItem, retrieveChestMethodOneItem);
        String generatedListItemOne = treasureInteractionComponentGenerator.generateItemList(treasure).get(0);
        return TreasureInteractionComponentGenerator.TREASURE_INTERACTION_IMPORT_TEMPLATE +
                "\n\n\n" + generatedListItemOne +
                "\n\n\n" + generatedClassOneItem;
    }

    public String generateTreasureInteractionCodeForZeroItem(Treasure treasure, String convertedMapName, String generatedSuperMethod) {
        String methodArgumentsZeroItem = String.format(TreasureInteractionComponentGenerator.METHOD_ARGUMENTS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()), "", "", "", "", "", "", "", "").trim();
        String retrieveChestMethodZeroItem = String.format(TreasureInteractionComponentGenerator.RETRIEVE_CHEST_CONTENT_TEMPLATE, "", "", "", "");
        String generatedClassZeroItem = String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, convertedMapName, generatedSuperMethod, methodArgumentsZeroItem, retrieveChestMethodZeroItem);
        return TreasureInteractionComponentGenerator.TREASURE_INTERACTION_IMPORT_TEMPLATE + "\n\n\n" +
                "\n\n\n" + generatedClassZeroItem;
    }
}

