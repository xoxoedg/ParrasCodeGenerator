package rug.parras.parrascodegenerator.Area;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.*;
import rug.parras.parrascodegenerator.Area.AreaGenerator.common.ValidationAreaResult;
import rug.parras.parrascodegenerator.Area.AreaGenerator.common.ValidationAreaStatus;

import java.io.IOException;

@Service
public class AreaGenerationService {

    GameDirectoryGeneratorService gameDirectoryGeneratorService;
    FileGenerationService fileGenerationService;
    CodeGenerationService codeGenerationService;
    AreaValidationService validationService;

    public AreaGenerationService(GameDirectoryGeneratorService gameDirectoryGeneratorService, FileGenerationService fileGenerationService, CodeGenerationService codeGenerationService) {
        this.gameDirectoryGeneratorService = gameDirectoryGeneratorService;
        this.fileGenerationService = fileGenerationService;
        this.codeGenerationService = codeGenerationService;
    }

    public ValidationAreaResult createArea(Area area) {

        ValidationAreaResult validationAreaResult = validationService.validateAreaInput(area.getAreaName());
        if (validationAreaResult.getValidationStatus() == ValidationAreaStatus.SUCCESS) {
            gameDirectoryGeneratorService.createAllDirectories(area.getAreaName());
            fileGenerationService.createFiles(area.getAreaName());
            validationAreaResult.setUrl("index");
            return validationAreaResult;

//            codeGenerationService.createCode(area.getAreaName());
        }
        validationAreaResult.setUrl("error");
        return validationAreaResult;
    }
}
