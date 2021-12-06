package rug.parras.parrascodegenerator.directoryGenerator.ConfigurationCodeGenerator;

import rug.parras.parrascodegenerator.directoryGenerator.FactoryFileGenerator;

import java.io.File;

public class ConfigurationFileGenerator {

    private final String CONFIGURATION_FILE_TEMPLATE = "configuration.py";

    public File createFile() {
        return new File(CONFIGURATION_FILE_TEMPLATE);
    }
}
