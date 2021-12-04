package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreasureInteractionCodeGenerationService {

    private TreasureComponentGenerator treasureComponentGenerator;

    public TreasureInteractionCodeGenerationService(TreasureComponentGenerator treasureComponentGenerator) {
        this.treasureComponentGenerator = treasureComponentGenerator;
    }

    public String generateTreasureInteraction(Treasure treasure) {
            StringBuilder generatedTreasureInteraction = new StringBuilder();
            List<String> treasureInteractionComponents = List.of(
                    TreasureComponentGenerator.TREASURE_INTERACTION_IMPORT_TEMPLATE
                            + "\n\n" , treasureComponentGenerator.generateRewardList(treasure)
                            + "\n\n", treasureComponentGenerator.generateClassName(treasure) + "\n\n", "\t"
                            + treasureComponentGenerator.generateClassConstructor(treasure)
                            + "\n\n" + "\t" + treasureComponentGenerator.generateRetrieveChestMethod(treasure));
            treasureInteractionComponents.forEach(generatedTreasureInteraction::append);
            return generatedTreasureInteraction.toString();
        }
    }


