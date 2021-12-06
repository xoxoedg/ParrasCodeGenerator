package rug.parras.parrascodegenerator.directoryGenerator.BattleFactory;

import rug.parras.parrascodegenerator.directoryGenerator.FactoryFileGenerator;

import java.io.File;

public class BattleFactoryFileGenerator implements FactoryFileGenerator {

    private static final String BATTLE_FACTORY_FILE_TEMPLATE = "%s_battle_factory.py";

    @Override
    public String generateFilename(String areaName) {

        return String.format(BATTLE_FACTORY_FILE_TEMPLATE, areaName);
    }

    @Override
    public File createFile(String areaName) {
        return new File(generateFilename(areaName));
    }
}
