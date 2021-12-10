package rug.parras.parrascodegenerator.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rug.parras.parrascodegenerator.Map.Validation.ValidationResult;

@Controller
public class MapController {

    private final MapService mapService;

    @Autowired
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/map")
    public String getMapPage(Model model) {
        model.addAttribute("generatedMap", new Map());
        return "mapGenerator";
    }

    @PostMapping("/map")
    public String mapSubmit(@ModelAttribute Map map, Model model) {
        ValidationResult result = mapService.createMap(map);
        model.addAttribute("errorReasons", map);
        return result.getUrl();
    }
}
