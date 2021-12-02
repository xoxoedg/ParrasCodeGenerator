package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;

@Service
public class TreasureInteractionService {

    TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService;
    TreasureInteractionComponentGenerator treasureInteractionComponentGenerator;

    @Autowired
    public TreasureInteractionService(TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService) {
        this.treasureInteractionCodeGenerationService = treasureInteractionCodeGenerationService;
    }

    public TreasureInteractionService(TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService, TreasureInteractionComponentGenerator treasureInteractionComponentGenerator) {
        this.treasureInteractionCodeGenerationService = treasureInteractionCodeGenerationService;
        this.treasureInteractionComponentGenerator = treasureInteractionComponentGenerator;
    }

    public String generateTreasureInteractionClass(Treasure treasure) {
        String receiveGoldArgument = String.format(TreasureInteractionComponentGenerator.TREASURE_INTERACTION_LIST_RECEIVE_GOLD_NAME_TEMPLATE, MapParser.convertInputToUppercaseMap(treasure.getMap()));
        String convertedMapName = MapParser.convertInputToMapName(treasure.getMap());
        String generatedSuperMethod = treasureInteractionComponentGenerator.generateSuperMethod(treasure);
        String generatedGoldList = treasureInteractionComponentGenerator.generateGoldList(treasure);

        if (treasure.getAmountGold() == 0) {
            switch (treasureInteractionComponentGenerator.filterItems(treasure).size()) {
                case 0:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionCodeForZeroItem(treasure, convertedMapName, generatedSuperMethod);

                case 1:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionCodeForOneItem(treasure, convertedMapName, generatedSuperMethod);
                case 2:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionCodeForTwoItem(treasure, convertedMapName, generatedSuperMethod);
                case 3:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionCodeForThreeItems(treasure, convertedMapName, generatedSuperMethod);
                default:
                    return "";
            }
        } else {
            switch (treasureInteractionComponentGenerator.filterItems(treasure).size()) {

                case 0:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionCodeForZeroItemsAndGold(treasure, receiveGoldArgument, convertedMapName, generatedSuperMethod);
                case 1:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionCodeForOneItemsAndGold(treasure, receiveGoldArgument, convertedMapName, generatedSuperMethod);
                case 2:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionForTwoItemsAndGold(treasure, receiveGoldArgument, convertedMapName, generatedSuperMethod);
                case 3:
                    return treasureInteractionCodeGenerationService.generateTreasureInteractionForThreeItemsAndGold(treasure, receiveGoldArgument, convertedMapName, generatedSuperMethod);
                default:
                    return "";
            }
        }
    }
}
