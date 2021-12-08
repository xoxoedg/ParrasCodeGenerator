package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class MapAfterInteractionFactoryFileGenerator extends GamePath implements FactoryFileGenerator {

    private final String MAP_AFTER_INTERACTION_FACTORY_FILE_GENERATOR = "%s\\src\\worldmap\\%s\\maps\\factories\\%s_map_after_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(MAP_AFTER_INTERACTION_FACTORY_FILE_GENERATOR, path ,areaName, areaName);
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(generateFilename(areaName)).createNewFile();
    }
}
