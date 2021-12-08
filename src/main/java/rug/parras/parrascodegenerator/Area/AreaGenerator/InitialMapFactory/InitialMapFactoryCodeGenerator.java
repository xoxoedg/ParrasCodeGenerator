package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;

@Component
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
