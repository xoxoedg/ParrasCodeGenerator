package rug.parras.parrascodegenerator.Area;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rug.parras.parrascodegenerator.Area.AreaGenerator.Area;
import rug.parras.parrascodegenerator.Area.Validation.ValidationResult;

@Controller
public class AreaGenerationController {

    private final AreaGenerationService areaGenerationService;

    public AreaGenerationController(AreaGenerationService areaGenerationService) {
        this.areaGenerationService = areaGenerationService;
    }

    @GetMapping("/area")
    public String getAreaPage(Model model) {
        model.addAttribute("area", new Area());
        return "areaGenerator";
    }

    @PostMapping("/area")
    public String areaSubmit(@ModelAttribute Area area, Model model) {
        ValidationResult result = areaGenerationService.createArea(area);
        model.addAttribute("errorReasons", result);
        System.out.println(result.getUrl());
        return result.getUrl();
    }
}
