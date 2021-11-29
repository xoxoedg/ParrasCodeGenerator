package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@Builder
@AllArgsConstructor
public class Treasure {

    public static final String TREASURE_INTERACTION_CLASS_TEMPLATE =
            "class EstuaryChestInteraction(StandardTreasureInteraction):\n" +
                    "\n" +
                    "    def __init__(self, timeline):\n" +
                    "        super(EstuaryChestInteraction, self).__init__(timeline, 'RECEIVED_ESTUARY_MAP_CHEST', RECEIVE_GOLD_IN_ESTUARY_MAP)\n" +
                    "\n" +
                    "    def retrieve_chest_content(self, hero):\n" +
                    "        hero.gold += 300";

    public static final String TREASURE_INTERACTION_LIST_ITEM_NAME_TEMPLATE =
            "RECEIVE_GOLD_IN_%s";

    public static final String TREASURE_INTERACTION_LIST_GOLD_TEMPLATE =
            "RECEIVE_%s";

    public static final String TREASURE_INTERACTION_LIST_ITEM_TEXT_TEMPLATE =
            "['%s']";

    public static final String TREASURE_INTERACTION_LIST_GOLD_TEXT_TEMPLATE =
            "['%s']";


    public static final String TREASURE_INTERACTION_IMPORT_TEMPLATE =
            "from characters.item_interaction.common.standard_treasure_interaction import StandardTreasureInteraction";



}
