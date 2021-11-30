package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Treasure {

    public static final String TREASURE_INTERACTION_CLASS_TEMPLATE =
            "class %sChestInteraction(StandardTreasureInteraction):\n" +
                    "\n" +
                    "    def __init__(self, timeline):\n" +
                    "        super(%sChestInteraction, self).__init__(timeline, 'RECEIVED_%s_CHEST%s%s%s%s%s%s%s%s)\n" +
                    "\n" +
                    "    def retrieve_chest_content(self, hero):\n" +
                    "        %s\n" +
                    "        %s\n" +
                    "        %s\n" +
                    "        %s";

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
    private int amountGold;
    private String itemOneName;
    private int itemOneAmount;
    private String itemTwoName;
    private int itemTwoAmount;
    private String itemThreeName;
    private int itemThreeAmount;



    public Treasure() {
        this.itemOneAmount = 0;
        this.itemTwoAmount = 0;
        this.itemThreeAmount = 0;
        this.itemOneName = "";
        this.itemTwoName = "";
        this.itemThreeName = "";
        this.amountGold = 0;
    }
}

