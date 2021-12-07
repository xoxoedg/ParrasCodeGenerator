package rug.parras.parrascodegenerator.AreaGenerator.blub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.blub.BattleFactory.BattleFactoryFileGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.ConfigurationCodeGenerator.ConfigurationFileGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.InitialMapFactory.InitialMapFactoryFileGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.ItemInteractionFactory.ItemInteractionFactoryFileGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.MapInteractionFactoryCodeGenerator.MapAfterInteractionFactoryFileGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.NextMapFactory.NextMapFactoryFileGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.ScenceFactory.SceneFactoryFileGenerator;

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

}
