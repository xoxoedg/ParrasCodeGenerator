package rug.parras.parrascodegenerator.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Map.Validation.MapValidationService;
import rug.parras.parrascodegenerator.Map.Validation.ValidationResult;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class MapService {

    private final MapCodeGenerationService mapCodeGenerationService;
    private final MapValidationService mapValidationService;

    @Autowired
    public MapService(MapCodeGenerationService mapCodeGenerationService,
                      MapValidationService mapValidationService) {
        this.mapCodeGenerationService = mapCodeGenerationService;
        this.mapValidationService = mapValidationService;
    }

    public ValidationResult createMap(Map map) {
        ValidationResult validationResult = mapValidationService.validateInput(map);
        if (validationResult.getValidationStatus() == ValidationStatus.SUCCESS) {
            try {
                FileOperationsUtils.writeToFile(mapCodeGenerationService.generateMap(map), new File("testPythonDir//" + map.getFilename().toLowerCase()));
                validationResult.setUrl("index");
                return validationResult;
            } catch (IOException e) {
                log.error("Error" + e.getMessage());
                validationResult.setUrl("error");
                validationResult.setMessage("Following Exception occurred" + e.getMessage());
                return validationResult;
            }
        } else {
            validationResult.setUrl("mapError");
            return validationResult;
        }
    }
}
