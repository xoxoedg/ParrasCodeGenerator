package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;


import rug.parras.parrascodegenerator.Interactions.common.MapParser;

public class TreasureInteractionCodeGenerationService {

    private TreasureInteractionTemplateHelper treasureInteractionTemplateHelper;

    public String createTreasureInteractionClass(Treasure treasure) {
        treasureInteractionTemplateHelper = new TreasureInteractionTemplateHelper();
        return String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, MapParser.convertInputToMapName(treasure.getMap()),
                treasureInteractionTemplateHelper.generateSuperMethod(treasure)
                ,treasureInteractionTemplateHelper.generateFunctionArguments(treasure),
                treasureInteractionTemplateHelper.generateRetrieveChestMethod(treasure));
    }
}
