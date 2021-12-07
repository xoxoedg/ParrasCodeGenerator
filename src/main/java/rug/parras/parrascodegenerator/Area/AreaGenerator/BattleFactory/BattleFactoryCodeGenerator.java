package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import lombok.Getter;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;

@Getter
public class BattleFactoryCodeGenerator implements FactoryCodeGenerator {


    private final String BATTLE_FACTORY_CODE_TEMPLATE =
            "class %sDungeonBattleFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_battle(cls, hero):\n" +
                    "          pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(BATTLE_FACTORY_CODE_TEMPLATE, areaName);
    }
}
