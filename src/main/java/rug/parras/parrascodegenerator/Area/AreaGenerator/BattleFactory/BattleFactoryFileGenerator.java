package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class BattleFactoryFileGenerator extends GamePath implements FactoryFileGenerator {

    private static final String BATTLE_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\battles\\%s\\%s_battle_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(BATTLE_FACTORY_FILE_TEMPLATE, path, areaName.toLowerCase(), areaName.toLowerCase());
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(generateFilename(areaName)).createNewFile();
    }
}
