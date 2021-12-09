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
    AreaValidationService areaValidationService;
    ValidationIOService validationIOService;

    @Autowired
    public AreaGenerationService(GameDirectoryGeneratorService gameDirectoryGeneratorService,
                                 FileGenerationService fileGenerationService,
                                 CodeWriterService codeWriterService,
                                 AreaValidationService areaValidationService,
                                 ValidationIOService validationIOService) {
        this.gameDirectoryGeneratorService = gameDirectoryGeneratorService;
        this.fileGenerationService = fileGenerationService;
        this.codeWriterService = codeWriterService;
        this.areaValidationService = areaValidationService;
        this.validationIOService = validationIOService;
    }

    public ValidationResult createArea(Area area) {

        ValidationAreaResult validationAreaResult = areaValidationService.validateAreaInput(area.getAreaName());
        ValidationIOResult validationIOResult =  validationIOService.validateFiles(area.getAreaName());
        if (validationAreaResult.getValidationStatus() == ValidationStatus.SUCCESS) {
            gameDirectoryGeneratorService.createAllDirectories(area.getAreaName());
            fileGenerationService.createFiles(area.getAreaName());
            codeWriterService.writeCodeToFile(area.getAreaName());
            validationIOResult.setUrl("areaGeneratorResult");
            return validationIOResult;
        }
        validationAreaResult.setUrl("error");
        return validationAreaResult;
    }
}
