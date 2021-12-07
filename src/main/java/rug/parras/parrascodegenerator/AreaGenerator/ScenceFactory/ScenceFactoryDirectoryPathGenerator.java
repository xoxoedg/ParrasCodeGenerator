package rug.parras.parrascodegenerator.AreaGenerator.ScenceFactory;

import rug.parras.parrascodegenerator.AreaGenerator.DirectoryPathGenerator;

public class ScenceFactoryDirectoryPathGenerator implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\scenes\\%s";


    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, "configBeanPlaceholder", areaName);
    }

    public String createSubDirectoryConversationsPath(String areaName) {
        return createDirectoryPath(areaName) + "\\conversations";
    }

    public String createSubDirectoryScencesPath(String areaName) {
        return createDirectoryPath(areaName) + "\\sprites";
    }

}
