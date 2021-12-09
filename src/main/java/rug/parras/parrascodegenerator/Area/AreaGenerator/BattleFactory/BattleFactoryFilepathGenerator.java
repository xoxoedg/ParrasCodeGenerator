package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

@Component
@Setter
@Getter
public class BattleFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String BATTLE_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\battles\\%s\\%s_battle_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(BATTLE_FACTORY_FILE_TEMPLATE, path, areaName.toLowerCase(), areaName.toLowerCase());
    }
}
