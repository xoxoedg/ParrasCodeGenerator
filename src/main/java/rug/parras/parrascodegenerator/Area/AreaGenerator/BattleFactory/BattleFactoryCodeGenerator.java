package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import lombok.Getter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
@Getter
public class BattleFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String BATTLE_FACTORY_CODE_TEMPLATE =
            "class %sBattleFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_battle(cls, hero):\n" +
                    "        pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(BATTLE_FACTORY_CODE_TEMPLATE, StringOperationUtils.convertSpaceToCamelCase(areaName));
    }
}
