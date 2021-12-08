package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator.ConfigurationFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory.InitialMapFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory.NextMapFactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryFileGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

@Service
public class FileGenerationService {

    @Autowired
    public FileGenerationService(BattleFactoryFileGenerator battleFactoryFileGenerator,
                                 ConfigurationFileGenerator configurationFileGenerator,
                                 InitialMapFactoryFileGenerator initialMapFactoryFileGenerator,
                                 ItemInteractionFactoryFileGenerator itemInteractionFactoryFileGenerator,
                                 MapAfterInteractionFactoryFileGenerator mapAfterInteractionFactoryFileGenerator,
                                 NextMapFactoryFileGenerator nextMapFactoryFileGenerator,
                                 SceneFactoryFileGenerator sceneFactoryFileGenerator) {
        this.battleFactoryFileGenerator = battleFactoryFileGenerator;
        this.configurationFileGenerator = configurationFileGenerator;
        this.initialMapFactoryFileGenerator = initialMapFactoryFileGenerator;
        this.itemInteractionFactoryFileGenerator = itemInteractionFactoryFileGenerator;
        this.mapAfterInteractionFactoryFileGenerator = mapAfterInteractionFactoryFileGenerator;
        this.nextMapFactoryFileGenerator = nextMapFactoryFileGenerator;
        this.sceneFactoryFileGenerator = sceneFactoryFileGenerator;
    }

    BattleFactoryFileGenerator battleFactoryFileGenerator;
    ConfigurationFileGenerator configurationFileGenerator;
    InitialMapFactoryFileGenerator initialMapFactoryFileGenerator;
    ItemInteractionFactoryFileGenerator itemInteractionFactoryFileGenerator;
    MapAfterInteractionFactoryFileGenerator mapAfterInteractionFactoryFileGenerator;
    NextMapFactoryFileGenerator nextMapFactoryFileGenerator;
    SceneFactoryFileGenerator sceneFactoryFileGenerator;

    public void createFiles(String areaName) {
        try {
            battleFactoryFileGenerator.createFile(areaName);
            configurationFileGenerator.createFile(areaName);
            initialMapFactoryFileGenerator.createFile(areaName);
            itemInteractionFactoryFileGenerator.createFile(areaName);
            mapAfterInteractionFactoryFileGenerator.createFile(areaName);
            nextMapFactoryFileGenerator.createFile(areaName);
            sceneFactoryFileGenerator.createFile(areaName);
        } catch (IOException e) {
            throw new RuntimeException("Blub exception");
        }
    }
}
