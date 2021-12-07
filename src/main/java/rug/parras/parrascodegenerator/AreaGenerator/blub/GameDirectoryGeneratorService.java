package rug.parras.parrascodegenerator.AreaGenerator.blub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.blub.BattleFactory.BattleFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.AreaGenerator.blub.ItemInteractionFactory.ItemInteractionDirectoryGeneratorService;
import rug.parras.parrascodegenerator.AreaGenerator.blub.ScenceFactory.SceneFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.AreaGenerator.blub.WorldMap.WorldMapDirectoryPathGeneratorService;

@Service
public class GameDirectoryGeneratorService {

    BattleFactoryDirectoryGeneratorService battleFactoryDirectoryGeneratorService;
    ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService;
    SceneFactoryDirectoryGeneratorService sceneFactoryDirectoryGeneratorService;
    WorldMapDirectoryPathGeneratorService worldMapDirectoryPathGeneratorService;

    @Autowired
    public GameDirectoryGeneratorService(WorldMapDirectoryPathGeneratorService worldMapDirectoryPathGeneratorService, ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService, SceneFactoryDirectoryGeneratorService sceneFactoryDirectoryGeneratorService, BattleFactoryDirectoryGeneratorService battleFactoryDirectoryGeneratorService) {
        this.battleFactoryDirectoryGeneratorService = battleFactoryDirectoryGeneratorService;
        this.itemInteractionDirectoryGeneratorService = itemInteractionDirectoryGeneratorService;
        this.sceneFactoryDirectoryGeneratorService = sceneFactoryDirectoryGeneratorService;
        this.worldMapDirectoryPathGeneratorService = worldMapDirectoryPathGeneratorService;
    }

    public void  createAllDirectories(String areaName) {
        battleFactoryDirectoryGeneratorService.createDirectories(areaName);
        itemInteractionDirectoryGeneratorService.createDirectories(areaName);
        sceneFactoryDirectoryGeneratorService.createDirectories(areaName);
        worldMapDirectoryPathGeneratorService.createDirectories(areaName);
    }
}
