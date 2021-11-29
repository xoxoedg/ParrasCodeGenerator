package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@Builder
@AllArgsConstructor
public class Treasure {
//Textblock
    public static final String TREASURE_INTERACTION_CLASS_TEMPLATE =
            "class %sChestInteraction(StandardTreasureInteraction):\n" +
                    "\n" +
                    "    def __init__(self, timeline):\n" +
                    "        super(%sChestInteraction, self).__init__(timeline, 'RECEIVED_%s_CHEST', RECEIVE_%s)\n" +
                    "\n" +
                    "    def retrieve_chest_content(self, hero):\n" +
                    "        hero.gold += %s";

    public static final String TREASURE_INTERACTION_CLASS_GOLD_TEMPLATE =
            "class %sChestInteraction(StandardTreasureInteraction):\n" +
                    "\n" +
                    "    def __init__(self, timeline):\n" +
                    "        super(%sChestInteraction, self).__init__(timeline, 'RECEIVED_%s_CHEST', RECEIVE_GOLD_IN_%s)\n" +
                    "\n" +
                    "    def retrieve_chest_content(self, hero):\n" +
                    "        hero.gold += %s";

    public static final String TREASURE_INTERACTION_CLASS_GOLD_AND_ITEM_TEMPLATE =
            "class %sChestInteraction(StandardTreasureInteraction):\n" +
                    "\n" +
                    "    def __init__(self, timeline):\n" +
                    "        super(%sChestInteraction, self).__init__(timeline, 'RECEIVED_%s_CHEST', RECEIVE_GOLD_IN_%s, RECEIVE_%s)\n" +
                    "\n" +
                    "    def retrieve_chest_content(self, hero):\n" +
                    "        hero.gold += %s\n" +
                    "        hero.items.%s.amount += %s";

    public static final String TREASURE_INTERACTION_LIST_ITEM_NAME_TEMPLATE =
            "RECEIVE_GOLD_IN_%s";

    public static final String TREASURE_INTERACTION_LIST_GOLD_TEMPLATE =
            "RECEIVE_%s";

    public static final String TREASURE_INTERACTION_LIST_ITEM_TEXT_TEMPLATE =
            "['Received %s']";

    public static final String TREASURE_INTERACTION_LIST_GOLD_TEXT_TEMPLATE =
            "['You receive %s gold']";


    public static final String TREASURE_INTERACTION_IMPORT_TEMPLATE =
            "from characters.item_interaction.common.standard_treasure_interaction import StandardTreasureInteraction";

    private String map;
    private String area;
    private String fileName;
    private String amountGold;
    private String itemName;
    private String amountItems;



}
