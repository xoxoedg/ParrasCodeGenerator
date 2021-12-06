package rug.parras.parrascodegenerator.directoryGenerator.MapInteractionFactoryCodeGenerator;

import rug.parras.parrascodegenerator.directoryGenerator.FactoryFileGenerator;

import java.io.File;

public class MapAfterInteractionFactoryFileGenerator implements FactoryFileGenerator {

    private final String MAP_AFTER_INTERACTION_FACTORY_FILE_GENERATOR = "%s_next_map_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(MAP_AFTER_INTERACTION_FACTORY_FILE_GENERATOR, areaName);
    }

    @Override
    public File createFile(String areaName) {
        return new File(generateFilename(areaName));
    }
}
