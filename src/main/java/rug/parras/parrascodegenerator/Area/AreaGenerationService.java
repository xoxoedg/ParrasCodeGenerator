package rug.parras.parrascodegenerator.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.*;
import rug.parras.parrascodegenerator.Area.Validation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaGenerationService {

    GameDirectoryGeneratorService gameDirectoryGeneratorService;
    FileGenerationService fileGenerationService;
    CodeWriterService codeWriterService;
    AreaValidationService validationService;
    ValidationIOService validationIOService;

    @Autowired
    public AreaGenerationService(GameDirectoryGeneratorService gameDirectoryGeneratorService,
                                 FileGenerationService fileGenerationService,
                                 CodeWriterService codeWriterService,
                                 AreaValidationService validationService,
                                 ValidationIOService validationIOService) {
        this.gameDirectoryGeneratorService = gameDirectoryGeneratorService;
        this.fileGenerationService = fileGenerationService;
        this.codeWriterService = codeWriterService;
        this.validationService = validationService;
        this.validationIOService = validationIOService;
    }

    public List<ValidationResult> createArea(Area area) {

        ValidationAreaResult validationAreaResult = validationService.validateAreaInput(area.getAreaName());
        List<ValidationResult> validationResults = List.of(validationAreaResult);
        ValidationStatus validationStatus = validationAreaResult.getValidationStatus();
        if (validationStatus == ValidationStatus.SUCCESS) {
            validationResults.add(validationIOService.validateFiles(area.getAreaName()));
            gameDirectoryGeneratorService.createAllDirectories(area.getAreaName());
            fileGenerationService.createFiles(area.getAreaName());
            codeWriterService.writeCodeToFile(area.getAreaName());
            validationAreaResult.setUrl("index");
            return validationResults;
        }
        validationAreaResult.setUrl("error");
        return validationResults;
    }
}
