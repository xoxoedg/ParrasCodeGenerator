package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class NextMapFactoryFileGenerator extends GamePath implements FactoryFileGenerator {

    private static final String NEXT_MAP_FACTORY_FILE_TEMPLATE = "%s\\src\\worldmap\\%s\\maps\\factories\\%s_next_map_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(NEXT_MAP_FACTORY_FILE_TEMPLATE, path, areaName, areaName);
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(generateFilename(areaName)).createNewFile();
    }
}
