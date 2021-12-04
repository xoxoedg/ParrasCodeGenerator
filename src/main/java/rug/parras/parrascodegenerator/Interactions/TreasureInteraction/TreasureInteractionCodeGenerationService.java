package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreasureInteractionCodeGenerationService {

    private TreasureComponentBuilder treasureComponentBuilder;

    public TreasureInteractionCodeGenerationService(TreasureComponentBuilder treasureComponentBuilder) {
        this.treasureComponentBuilder = treasureComponentBuilder;
    }

    public String createTreasureInteraction(Treasure treasure) {
            StringBuilder generatedTreasureInteraction = new StringBuilder();
            List<String> treasureInteractionComponents = List.of(
                    TreasureComponentBuilder.TREASURE_INTERACTION_IMPORT_TEMPLATE
                            + "\n\n" ,treasureComponentBuilder.generateRewardList(treasure)
                            + "\n\n", treasureComponentBuilder.generateClassName(treasure) + "\n\n", "\t"
                            + treasureComponentBuilder.generateClassConstructor(treasure)
                            + "\n\n" + "\t" + treasureComponentBuilder.generateRetrieveChestMethod(treasure));
            treasureInteractionComponents.forEach(generatedTreasureInteraction::append);
            return generatedTreasureInteraction.toString();
        }
    }


