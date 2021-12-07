package rug.parras.parrascodegenerator.AreaGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.BattleFactory.BattleFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.AreaGenerator.ItemInteractionFactory.ItemInteractionDirectoryGeneratorService;
import rug.parras.parrascodegenerator.AreaGenerator.ScenceFactory.SceneFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.AreaGenerator.WorldMap.WorldMapDirectoryPathGeneratorService;

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
