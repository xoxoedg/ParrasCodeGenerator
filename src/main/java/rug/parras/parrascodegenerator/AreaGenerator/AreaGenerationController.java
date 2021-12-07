package rug.parras.parrascodegenerator.AreaGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rug.parras.parrascodegenerator.AreaGenerator.AreaGenerationService;
import rug.parras.parrascodegenerator.AreaGenerator.blub.Area;

@Controller
public class AreaGenerationController {

    private final AreaGenerationService areaGenerationService;

    public AreaGenerationController(AreaGenerationService areaGenerationService) {
        this.areaGenerationService = areaGenerationService;
    }

    @GetMapping("/area")
    public String getAreaPage(Model model) {
        model.addAttribute("area", new Area());
        return "area";
    }

    @PostMapping
    public String areaSubmit(@ModelAttribute Area area, Model model) {
        areaGenerationService.createArea(area);
        return "index";
    }

}
