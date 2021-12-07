package rug.parras.parrascodegenerator.AreaGenerator.blub.BattleFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.AreaGenerator.blub.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;

@Component
public class BattleFactoryFileGenerator implements FactoryFileGenerator {

    private static final String BATTLE_FACTORY_FILE_TEMPLATE = "%s_battle_factory.py";

    @Override
    public String generateFilename(String areaName) {

        return String.format(BATTLE_FACTORY_FILE_TEMPLATE, areaName.toLowerCase());
    }

    @Override
    public File createFile(String areaName) {
        return new File(generateFilename(areaName));
    }
}
