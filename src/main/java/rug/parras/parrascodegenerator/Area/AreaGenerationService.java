package rug.parras.parrascodegenerator.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.Area;
import rug.parras.parrascodegenerator.Area.AreaGenerator.CodeWriterService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.FileGenerationService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GameDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.Validation.*;
import rug.parras.parrascodegenerator.common.ValidationStatus;

@Service
public class AreaGenerationService {

    private final GameDirectoryGeneratorService gameDirectoryGeneratorService;
    private final FileGenerationService fileGenerationService;
    private final CodeWriterService codeWriterService;
    private final ValidationAreaService validationAreaService;
    private final ValidationIOService validationIOService;

    @Autowired
    public AreaGenerationService(GameDirectoryGeneratorService gameDirectoryGeneratorService,
                                 FileGenerationService fileGenerationService,
                                 CodeWriterService codeWriterService,
                                 ValidationAreaService validationAreaService,
                                 ValidationIOService validationIOService) {
        this.gameDirectoryGeneratorService = gameDirectoryGeneratorService;
        this.fileGenerationService = fileGenerationService;
        this.codeWriterService = codeWriterService;
        this.validationAreaService = validationAreaService;
        this.validationIOService = validationIOService;
    }

    public ValidationResult createArea(Area area) {

        ValidationAreaResult validationAreaResult = validationAreaService.validateAreaInput(area.getAreaName());
        ValidationIOResult validationIOResult = validationIOService.validateFiles(area.getAreaName());
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
