package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInteractionController {

    SignInteractionService signInteractionService;
    Sign sign;

    @Autowired
    public SignInteractionController(SignInteractionService signInteractionService) {
        this.signInteractionService = signInteractionService;
        this.sign = new Sign();

    }

    @GetMapping("/sign")
    public String getSignPage(Model model) {
        model.addAttribute("signInteraction", sign);
        return "sign";
    }

    @PostMapping("/sign")
    public String signSubmit(@ModelAttribute Sign signInteraction, Model model) {
        model.addAttribute("signInteraction", sign);
        System.out.println(signInteraction.getFileName());
        signInteractionService.createSignInteraction(signInteraction);
        return "sign";
    }
}
