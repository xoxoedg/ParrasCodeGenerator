package rug.parras.parrascodegenerator.AreaGenerator.blub.ItemInteractionFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.blub.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.blub.GamePath;

@Component
public class ItemInteractionFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\item_interaction\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, areaName);
    }




}
