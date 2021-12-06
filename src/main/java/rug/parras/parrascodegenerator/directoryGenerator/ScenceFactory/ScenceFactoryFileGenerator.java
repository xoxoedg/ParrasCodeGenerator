package rug.parras.parrascodegenerator.directoryGenerator.ScenceFactory;

import rug.parras.parrascodegenerator.directoryGenerator.FactoryFileGenerator;

import java.io.File;

public class ScenceFactoryFileGenerator implements FactoryFileGenerator {

    private static final String SCENCE_FACTORY_FILE_TEMPLATE = "%s_item_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(SCENCE_FACTORY_FILE_TEMPLATE, areaName);
    }

    @Override
    public File createFile(String areaName) {
        return new File(areaName);
    }
}
