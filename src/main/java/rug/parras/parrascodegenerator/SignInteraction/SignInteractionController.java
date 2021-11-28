package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignInteractionController {

    SignInteractionService signInteractionService;

    @Autowired
    public SignInteractionController(SignInteractionService signInteractionService) {
        this.signInteractionService = signInteractionService;

    }

    @GetMapping("/sign")
    public String getSignPage(Model model) {
        model.addAttribute("signInteraction", new Sign());
        return "signGeneratorPage";
    }

    @PostMapping("/sign")
    public String signSubmit(@ModelAttribute Sign signInteraction, Model model) {
        signInteractionService.createSignInteraction(signInteraction);
        return "index";
    }
}
