package rug.parras.parrascodegenerator.directoryGenerator.BattleFactory;

import lombok.Getter;
import lombok.Setter;
import rug.parras.parrascodegenerator.directoryGenerator.Area;
@Setter
@Getter
public class BattleFactoryCodeGenerator {

    private final String BATTLE_FACTORY_CODE_TEMPLATE =
            "class RionnagenDungeonBattleFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_battle(cls, hero):\n" +
                    "          pass";

    public String generateBattleFactoryCode() {
        Area area = new Area();
        return String.format(BATTLE_FACTORY_CODE_TEMPLATE, area.getArea());
    }
}
