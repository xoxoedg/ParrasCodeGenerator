package rug.parras.parrascodegenerator.AreaGenerator.BattleFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class BattleFactoryDirectoryGeneratorService {

    BattleFactoryDirectoryPathGenerator battleFactoryDirectoryPathGenerator;

    @Autowired
    public BattleFactoryDirectoryGeneratorService(BattleFactoryDirectoryPathGenerator battleFactoryDirectoryPathGenerator) {
        this.battleFactoryDirectoryPathGenerator = battleFactoryDirectoryPathGenerator;
    }

    public void createDirectories(String areaName) {
        File directory = new File(battleFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();


    }

}
