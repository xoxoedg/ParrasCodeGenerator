package rug.parras.parrascodegenerator.directoryGenerator.InitialMapFactory;

import rug.parras.parrascodegenerator.directoryGenerator.FactoryCodeGenerator;

public class InitialMapFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String INITIAL_MAP_FACTORY_CODE_TEMPLATE =
            "class %sInitialMapFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def initial_map(cls, current_map):\n" +
                    "        pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(INITIAL_MAP_FACTORY_CODE_TEMPLATE, areaName);
    }
}
