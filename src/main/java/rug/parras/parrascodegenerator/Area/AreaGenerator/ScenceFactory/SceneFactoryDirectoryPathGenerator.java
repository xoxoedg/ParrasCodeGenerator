package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryPathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class SceneFactoryDirectoryPathGenerator extends GamePath implements DirectoryPathGenerator {

    private static final String PARRAS_DIRECTORY_PATH = "%s\\src\\characters\\scenes\\%s";


    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTORY_PATH, path, StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }

    public String createSubDirectoryConversationsPath(String areaName) {
        return createDirectoryPath(StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName)) + "\\conversations";
    }

    public String createSubDirectoryScenesPath(String areaName) {
        return createDirectoryPath(StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName)) + "\\sprites";
    }

}
