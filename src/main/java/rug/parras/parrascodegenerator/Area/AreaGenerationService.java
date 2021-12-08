package rug.parras.parrascodegenerator.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.*;
import rug.parras.parrascodegenerator.Area.AreaGenerator.common.ValidationAreaResult;
import rug.parras.parrascodegenerator.Area.AreaGenerator.common.ValidationAreaStatus;

@Service
public class AreaGenerationService {

    GameDirectoryGeneratorService gameDirectoryGeneratorService;
    FileGenerationService fileGenerationService;
    CodeWriterService codeWriterService;
    AreaValidationService validationService;

    @Autowired
    public AreaGenerationService(GameDirectoryGeneratorService gameDirectoryGeneratorService,
                                 FileGenerationService fileGenerationService,
                                 CodeWriterService codeWriterService,
                                 AreaValidationService validationService) {
        this.gameDirectoryGeneratorService = gameDirectoryGeneratorService;
        this.fileGenerationService = fileGenerationService;
        this.codeWriterService = codeWriterService;
        this.validationService = validationService;
    }

    public ValidationAreaResult createArea(Area area) {

        ValidationAreaResult validationAreaResult = validationService.validateAreaInput(area.getAreaName());
        if (validationAreaResult.getValidationStatus() == ValidationAreaStatus.SUCCESS) {
            gameDirectoryGeneratorService.createAllDirectories(area.getAreaName());
            fileGenerationService.createFiles(area.getAreaName());
            codeWriterService.writeCodeToFile(area.getAreaName());
            validationAreaResult.setUrl("index");
            return validationAreaResult;
        }
        validationAreaResult.setUrl("error");
        return validationAreaResult;
    }
}
