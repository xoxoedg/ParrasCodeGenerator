package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TreasureInteractionController {

    private TreasureInteractionService treasureInteractionService;

    @Autowired
    public TreasureInteractionController(TreasureInteractionService treasureInteractionService) {
        this.treasureInteractionService = treasureInteractionService;
    }


    @GetMapping("/treasure")
    public String getTreasurePage(Model model) {
        model.addAttribute("treasureInteraction", new Treasure());
        return "treasureGeneratorPage";
    }

    @PostMapping("/treasure")
    public String treasureSubmit(@ModelAttribute Treasure treasureInteraction, Model model) {
        model.addAttribute("errorReasons", treasureInteractionService.createErrorModel(treasureInteraction));
        return treasureInteractionService.createTreasureInteraction(treasureInteraction);

    }
}
