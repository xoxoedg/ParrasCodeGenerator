package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

@Service
public class TreasureInteractionService {

    TreasureComponentBuilder treasureComponentBuilder;

    @Autowired
    public TreasureInteractionService(TreasureComponentBuilder treasureComponentBuilder) {
        this.treasureComponentBuilder = treasureComponentBuilder;
    }

    public void createTreasureInteraction(Treasure treasure)  {

        try {
            FileOperationUtils converter = new FileOperationUtils("testPythonDir\\" + treasure.getFileName());
            converter.writeToFile(treasureComponentBuilder.generateTreasureInteraction(treasure));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

