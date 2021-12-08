package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;

public class MapAfterInteractionFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String MAP_AFTER_INTERACTION_FACTORY_CODE_TEMPLATE =
            "class %sMapAfterInteractionFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def change_map_on_interaction(cls, after, hero):\n" +
                    "             pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(MAP_AFTER_INTERACTION_FACTORY_CODE_TEMPLATE, areaName);
    }
}