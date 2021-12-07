package rug.parras.parrascodegenerator.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.AreaGenerator.GamePath;

@Component
public class SceneFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\scenes\\%s";


    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, areaName);
    }

    public String createSubDirectoryConversationsPath(String areaName) {
        return createDirectoryPath(areaName) + "\\conversations";
    }

    public String createSubDirectoryScencesPath(String areaName) {
        return createDirectoryPath(areaName) + "\\sprites";
    }

}
