package rug.parras.parrascodegenerator.AreaGenerator.InitialMapFactory;

import rug.parras.parrascodegenerator.AreaGenerator.FactoryFileGenerator;

import java.io.File;

public class InitialMapFactoryFileGenerator implements FactoryFileGenerator {

    private static final String INITIAL_MAP_FACTORY_FILE_TEMPLATE = "%s_initial_map_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(INITIAL_MAP_FACTORY_FILE_TEMPLATE, areaName);
    }

    @Override
    public File createFile(String areaName) {
        return new File(generateFilename(areaName));
    }
}
