package rug.parras.parrascodegenerator.directoryGenerator.BattleFactory;

import rug.parras.parrascodegenerator.directoryGenerator.Area;

import java.io.File;

public class BattleFactoryFileGenerator {

    private static final String BATTLE_FACTORY_FILE_TEMPLATE = "%s_battle_factory.py";
    private BattleFactoryCodeGenerator battleFactoryCodeGenerator;
    private Area area;

    public String generateFileName() {
        return String.format(BATTLE_FACTORY_FILE_TEMPLATE, area.getArea());
    }

    public File createFile() {
        return new File(generateFileName());
    }
}
