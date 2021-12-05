package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Treasure {

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

