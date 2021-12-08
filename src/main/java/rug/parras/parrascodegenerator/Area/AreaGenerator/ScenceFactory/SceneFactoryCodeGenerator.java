package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;

@Component
public class SceneFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String SCENE_FACTORY_CODE_TEMPLATE =
            "class %sSceneFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_scene(cls, hero):\n" +
                    "           pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(SCENE_FACTORY_CODE_TEMPLATE, areaName);
    }
}

