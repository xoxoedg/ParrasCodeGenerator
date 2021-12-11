package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryCodeGeneratorWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator.ConfigurationCodeGeneratorWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory.InitialMapFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory.NextMapFactoryCodeWriter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryCodeWriter;

import java.io.IOException;

@Service
public class CodeWriterService {

    private final BattleFactoryCodeGeneratorWriter battleFactoryCodeGeneratorWriter;
    private final ConfigurationCodeGeneratorWriter configurationCodeGeneratorWriter;
    private final InitialMapFactoryCodeWriter initialMapFactoryCodeWriter;
    private final ItemInteractionFactoryCodeWriter itemInteractionFactoryCodeWriter;
    private final MapAfterInteractionFactoryCodeWriter mapAfterInteractionFactoryCodeWriter;
    private final NextMapFactoryCodeWriter nextMapFactoryCodeWriter;
    private final SceneFactoryCodeWriter sceneFactoryCodeWriter;

    public CodeWriterService(BattleFactoryCodeGeneratorWriter battleFactoryCodeGeneratorWriter,
                             ConfigurationCodeGeneratorWriter configurationCodeGeneratorWriter,
                             InitialMapFactoryCodeWriter initialMapFactoryCodeWriter,
                             ItemInteractionFactoryCodeWriter itemInteractionFactoryCodeWriter,
                             MapAfterInteractionFactoryCodeWriter mapAfterInteractionFactoryCodeWriter,
                             NextMapFactoryCodeWriter nextMapFactoryCodeWriter,
                             SceneFactoryCodeWriter sceneFactoryCodeWriter) {

        this.battleFactoryCodeGeneratorWriter = battleFactoryCodeGeneratorWriter;
        this.configurationCodeGeneratorWriter = configurationCodeGeneratorWriter;
        this.initialMapFactoryCodeWriter = initialMapFactoryCodeWriter;
        this.itemInteractionFactoryCodeWriter = itemInteractionFactoryCodeWriter;
        this.mapAfterInteractionFactoryCodeWriter = mapAfterInteractionFactoryCodeWriter;
        this.nextMapFactoryCodeWriter = nextMapFactoryCodeWriter;
        this.sceneFactoryCodeWriter = sceneFactoryCodeWriter;
    }

    public void writeCodeToFile(String areaName) {
        try {
            battleFactoryCodeGeneratorWriter.writeToFile(areaName);
            configurationCodeGeneratorWriter.writeToFile(areaName);
            initialMapFactoryCodeWriter.writeToFile(areaName);
            itemInteractionFactoryCodeWriter.writeToFile(areaName);
            mapAfterInteractionFactoryCodeWriter.writeToFile(areaName);
            nextMapFactoryCodeWriter.writeToFile(areaName);
            sceneFactoryCodeWriter.writeToFile(areaName);
        } catch (IOException e) {
            throw new RuntimeException("Blub exception");
        }
    }
}
