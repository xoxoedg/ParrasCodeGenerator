package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory.ItemInteractionDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory.SceneFactoryDirectoryGeneratorService;
import rug.parras.parrascodegenerator.Area.AreaGenerator.WorldMap.WorldMapDirectoryGeneratorService;

@Service
public class GameDirectoryGeneratorService {

    BattleFactoryDirectoryGeneratorService battleFactoryDirectoryGeneratorService;
    ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService;
    SceneFactoryDirectoryGeneratorService sceneFactoryDirectoryGeneratorService;
    WorldMapDirectoryGeneratorService worldMapDirectoryPathGeneratorService;

    @Autowired
    public GameDirectoryGeneratorService(WorldMapDirectoryGeneratorService worldMapDirectoryPathGeneratorService, ItemInteractionDirectoryGeneratorService itemInteractionDirectoryGeneratorService, SceneFactoryDirectoryGeneratorService sceneFactoryDirectoryGeneratorService, BattleFactoryDirectoryGeneratorService battleFactoryDirectoryGeneratorService) {
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
