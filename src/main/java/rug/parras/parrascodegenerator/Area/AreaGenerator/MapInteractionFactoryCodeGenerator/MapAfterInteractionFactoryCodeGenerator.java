package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class MapAfterInteractionFactoryCodeGenerator implements FactoryCodeGenerator {

    private static final String MAP_AFTER_INTERACTION_FACTORY_CODE_TEMPLATE =
            "class %sMapAfterInteractionFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def change_map_on_interaction(cls, after, hero):\n" +
                    "        pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(MAP_AFTER_INTERACTION_FACTORY_CODE_TEMPLATE, StringOperationUtils.convertSpaceToCamelCase(areaName));
    }
}
