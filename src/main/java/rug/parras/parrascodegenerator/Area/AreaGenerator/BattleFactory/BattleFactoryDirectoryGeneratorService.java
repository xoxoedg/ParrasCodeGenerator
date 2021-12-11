package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryGenerator;

import java.io.File;

@Service
public class BattleFactoryDirectoryGeneratorService implements DirectoryGenerator {

    private final BattleFactoryDirectoryPathGenerator battleFactoryDirectoryPathGenerator;

    @Autowired
    public BattleFactoryDirectoryGeneratorService(BattleFactoryDirectoryPathGenerator battleFactoryDirectoryPathGenerator) {
        this.battleFactoryDirectoryPathGenerator = battleFactoryDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(battleFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdirs();


    }

}
