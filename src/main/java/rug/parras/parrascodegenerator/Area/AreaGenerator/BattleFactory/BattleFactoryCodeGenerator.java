package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import lombok.Getter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;

@Component
@Getter
public class BattleFactoryCodeGenerator implements FactoryCodeGenerator {

    private BattleFactoryDirectoryPathGenerator pathGenerator;
    private String BATTLE_FACTORY_FILE_TEMPLATE = "%s\\%s_battle_factory.py";
    private final String BATTLE_FACTORY_CODE_TEMPLATE =
            "class %sBattleFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_battle(cls, hero):\n" +
                    "        pass";

    @Override
    public String generateFactoryCode(String areaName) {
        pathGenerator = new BattleFactoryDirectoryPathGenerator();
        return String.format(BATTLE_FACTORY_CODE_TEMPLATE, areaName);
    }
}
