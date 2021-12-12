package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class ConfigurationFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private final String CONFIGURATION_FILE_TEMPLATE = "%s/src/worldmap/%s/configuration.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(CONFIGURATION_FILE_TEMPLATE, path, StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}

