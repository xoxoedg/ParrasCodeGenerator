package rug.parras.parrascodegenerator.AreaGenerator.BattleFactory;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class BattleFactoryDirectoryGeneratorService {

    public void createDirectories(String areaName) {
        BattleFactoryDirectoryPathGenerator battleFactoryDirectoryPathGenerator = new BattleFactoryDirectoryPathGenerator();
        File directory = new File(battleFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();


    }

}
