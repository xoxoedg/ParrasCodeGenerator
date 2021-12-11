package rug.parras.parrascodegenerator.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Map.Validation.MapValidationService;
import rug.parras.parrascodegenerator.Map.Validation.MapValidationStatus;
import rug.parras.parrascodegenerator.Map.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Service
public class MapService {

    MapCodeGenerationService mapCodeGenerationService;
    MapValidationService mapValidationService;

    @Autowired
    public MapService(MapCodeGenerationService mapCodeGenerationService,
                      MapValidationService mapValidationService) {
        this.mapCodeGenerationService = mapCodeGenerationService;
        this.mapValidationService = mapValidationService;
    }

    public ValidationResult createMap(Map map) {
        ValidationResult validationResult = mapValidationService.validateInput(map);
        if (validationResult.getMapValidationStatus() == MapValidationStatus.SUCCESS) {
            try {
                FileOperationsUtils.writeToFile(mapCodeGenerationService.generateMap(map),new File("testPythonDir/" + map.getFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            validationResult.setUrl("index");
            return validationResult;
        } else {
            validationResult.setUrl("mapError");
        }
        return validationResult;
    }
}
