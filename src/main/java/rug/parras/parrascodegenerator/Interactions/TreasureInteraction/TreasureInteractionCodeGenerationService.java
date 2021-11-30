package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import rug.parras.parrascodegenerator.Interactions.common.MapParser;

public class TreasureInteractionCodeGenerationService {

    private TreasureInteractionTemplateHelper treasureInteractionTemplateHelper;

    public String createTreasureInteractionClass(Treasure treasure) {
        return String.format(Treasure.TREASURE_INTERACTION_CLASS_TEMPLATE, treasure.getMap(),
                treasure.getMap());
    }
}
