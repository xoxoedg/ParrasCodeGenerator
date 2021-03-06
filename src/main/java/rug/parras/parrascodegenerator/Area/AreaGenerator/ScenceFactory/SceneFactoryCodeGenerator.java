package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class SceneFactoryCodeGenerator implements FactoryCodeGenerator {

    private static final String SCENE_FACTORY_CODE_TEMPLATE =
            "class %sSceneFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_scene(cls, hero):\n" +
                    "        pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(SCENE_FACTORY_CODE_TEMPLATE, StringOperationUtils.convertSpaceToCamelCase(areaName));
    }
}

