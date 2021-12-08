package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class ConfigurationFileGenerator extends GamePath {

    private final String CONFIGURATION_FILE_TEMPLATE = "%s\\src\\worldmap\\%s\\configuration.py";

    public String generateFilePath(String areaName) {
        return String.format(CONFIGURATION_FILE_TEMPLATE, path, areaName);
    }

    public boolean createFile(String areaName) throws IOException {
        return new File(generateFilePath(areaName)).createNewFile();
    }
}
