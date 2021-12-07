package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ConfigurationFileGenerator {

    private final String CONFIGURATION_FILE_TEMPLATE = "configuration.py";

    public File createFile() {
        return new File(CONFIGURATION_FILE_TEMPLATE);
    }
}
