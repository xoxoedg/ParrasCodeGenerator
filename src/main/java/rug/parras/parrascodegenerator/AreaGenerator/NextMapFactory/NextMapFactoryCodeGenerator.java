package rug.parras.parrascodegenerator.AreaGenerator.NextMapFactory;

import rug.parras.parrascodegenerator.AreaGenerator.FactoryCodeGenerator;

public class NextMapFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String NEXT_MAP_FACTORY_CODE_TEMPLATE =
            "class %sNextMapFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def next_map(cls, hero):\n" +
                    "           pass";


    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(NEXT_MAP_FACTORY_CODE_TEMPLATE, areaName);
    }
}
