package rug.parras.parrascodegenerator.AreaGenerator.blub.NextMapFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.blub.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;

@Component
public class NextMapFactoryFileGenerator implements FactoryFileGenerator {

    private static final String NEXT_MAP_FACTORY_FILE_TEMPLATE = "%s_next_map_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(NEXT_MAP_FACTORY_FILE_TEMPLATE, areaName);
    }

    @Override
    public File createFile(String areaName) {
        return new File(generateFilename(areaName));
    }
}
