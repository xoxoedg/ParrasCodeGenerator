package rug.parras.parrascodegenerator.directoryGenerator.ScenceFactory;

import rug.parras.parrascodegenerator.directoryGenerator.FactoryCodeGenerator;

public class ScenceFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String SCENCE_FACTORY_CODE_TEMPLATE =
            "class %sSceneFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_scene(cls, hero):\n" +
                    "           pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(SCENCE_FACTORY_CODE_TEMPLATE, areaName);
    }
}

