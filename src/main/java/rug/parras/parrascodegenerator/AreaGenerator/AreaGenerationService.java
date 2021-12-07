package rug.parras.parrascodegenerator.AreaGenerator;

import rug.parras.parrascodegenerator.AreaGenerator.blub.CodeGenerationService;
import rug.parras.parrascodegenerator.AreaGenerator.blub.FileGenerationService;
import rug.parras.parrascodegenerator.AreaGenerator.blub.GameDirectoryGeneratorService;

public class AreaGenerationService {

    GameDirectoryGeneratorService gameDirectoryGeneratorService;
    FileGenerationService fileGenerationService;
    CodeGenerationService codeGenerationService;

    public AreaGenerationService(GameDirectoryGeneratorService gameDirectoryGeneratorService, FileGenerationService fileGenerationService, CodeGenerationService codeGenerationService) {
        this.gameDirectoryGeneratorService = gameDirectoryGeneratorService;
        this.fileGenerationService = fileGenerationService;
        this.codeGenerationService = codeGenerationService;
    }
}
