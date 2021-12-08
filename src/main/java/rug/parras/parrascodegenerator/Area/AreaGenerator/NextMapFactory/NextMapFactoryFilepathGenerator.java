package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;


@Getter
@Setter
@Component
public class NextMapFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String NEXT_MAP_FACTORY_FILE_TEMPLATE = "%s\\src\\worldmap\\%s\\maps\\factories\\%s_next_map_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(NEXT_MAP_FACTORY_FILE_TEMPLATE, path, areaName, areaName.toLowerCase());
    }
}
