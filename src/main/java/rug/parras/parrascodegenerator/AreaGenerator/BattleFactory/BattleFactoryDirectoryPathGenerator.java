package rug.parras.parrascodegenerator.AreaGenerator.BattleFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.GamePath;

@Component
public class BattleFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\battles\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path ,areaName);
    }
}

