package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

@Service
public class TreasureInteractionService {
    TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService;


    @Autowired
    public TreasureInteractionService(TreasureInteractionCodeGenerationService treasureInteractionCodeGenerationService) {
        this.treasureInteractionCodeGenerationService = treasureInteractionCodeGenerationService;
    }


    public void createTreasureInteraction(Treasure treasure) {

        try {
            FileOperationUtils converter = new FileOperationUtils("testPythonDir\\" + treasure.getFileName());
            converter.writeToFile(treasureInteractionCodeGenerationService.generateTreasureInteraction(treasure));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

