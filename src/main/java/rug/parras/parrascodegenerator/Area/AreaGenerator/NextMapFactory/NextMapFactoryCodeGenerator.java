package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class NextMapFactoryCodeGenerator implements FactoryCodeGenerator {

    private static final String NEXT_MAP_FACTORY_CODE_TEMPLATE =
            "class %sNextMapFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def next_map(cls, hero):\n" +
                    "        pass";


    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(NEXT_MAP_FACTORY_CODE_TEMPLATE, StringOperationUtils.convertSpaceToCamelCase(areaName));
    }
}
