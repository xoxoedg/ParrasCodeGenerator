package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;
import java.io.IOException;

@Component
public class BattleFactoryFileGenerator implements FactoryFileGenerator {

    BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;

    @Autowired
    public BattleFactoryFileGenerator(BattleFactoryFilepathGenerator battleFactoryFilepathGenerator) {
        this.battleFactoryFilepathGenerator = battleFactoryFilepathGenerator;
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(battleFactoryFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}
