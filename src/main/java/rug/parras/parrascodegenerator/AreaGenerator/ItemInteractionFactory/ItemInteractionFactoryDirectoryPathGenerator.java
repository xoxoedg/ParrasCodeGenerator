package rug.parras.parrascodegenerator.AreaGenerator.ItemInteractionFactory;

import rug.parras.parrascodegenerator.AreaGenerator.DirectoryPathGenerator;

public class ItemInteractionFactoryDirectoryPathGenerator implements DirectoryPathGenerator {

    private final String PARRAS_DIRECTIORY_PATH = "%s\\src\\characters\\item_interaction\\%s";

    @Override
    public String createDirectoryPath(String areaName) {
        return String.format(PARRAS_DIRECTIORY_PATH, "configBeanPlaceholer", areaName);
    }




}
