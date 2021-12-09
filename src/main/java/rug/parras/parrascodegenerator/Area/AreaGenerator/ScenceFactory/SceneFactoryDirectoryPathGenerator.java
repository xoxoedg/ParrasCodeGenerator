package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

@Component
public class SceneFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\scenes\\%s";


    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, path, areaName.toLowerCase());
    }

    public String createSubDirectoryConversationsPath(String areaName) {
        return createDirectoryPath(areaName.toLowerCase()) + "\\conversations";
    }

    public String createSubDirectoryScenesPath(String areaName) {
        return createDirectoryPath(areaName.toLowerCase()) + "\\sprites";
    }

}
