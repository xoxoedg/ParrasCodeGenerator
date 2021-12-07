package rug.parras.parrascodegenerator.AreaGenerator;

import rug.parras.parrascodegenerator.AreaGenerator.blub.*;
import rug.parras.parrascodegenerator.AreaGenerator.blub.common.ValidationAreaResult;
import rug.parras.parrascodegenerator.AreaGenerator.blub.common.ValidationAreaStatus;


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
            codeGenerationService.createCode(area.getAreaName());
            validationAreaResult.setUrl("index");
            return validationAreaResult;
        }
        validationAreaResult.setUrl("error");
        return validationAreaResult;
    }
}
