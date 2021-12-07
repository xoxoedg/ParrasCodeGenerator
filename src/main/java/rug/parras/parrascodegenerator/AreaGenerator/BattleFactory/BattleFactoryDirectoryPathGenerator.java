package rug.parras.parrascodegenerator.AreaGenerator.BattleFactory;

import rug.parras.parrascodegenerator.AreaGenerator.DirectoryPathGenerator;


public class BattleFactoryDirectoryPathGenerator implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\battles\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, "",areaName);
    }
}

