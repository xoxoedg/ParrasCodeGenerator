package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class BattleFactoryCodeGeneratorWriter implements CodeWriterGenerator {

    BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;
    BattleFactoryCodeGenerator battleFactoryCodeGenerator;

    @Autowired
    public BattleFactoryCodeGeneratorWriter(BattleFactoryFilepathGenerator battleFactoryFilepathGenerator,
                                            BattleFactoryCodeGenerator battleFactoryCodeGenerator) {
        this.battleFactoryFilepathGenerator = battleFactoryFilepathGenerator;
        this.battleFactoryCodeGenerator = battleFactoryCodeGenerator;
    }

    @Override
    public void writeToFile(String areaName) throws IOException {
        File battleFactoryPythonFile = new File(battleFactoryFilepathGenerator.generateFilename(areaName));
        System.out.println(battleFactoryFilepathGenerator.generateFilename(areaName));
        FileWriter writer = new FileWriter(battleFactoryPythonFile);
        System.out.println(battleFactoryCodeGenerator.generateFactoryCode(areaName));
        writer.write(battleFactoryCodeGenerator.generateFactoryCode(areaName));
        writer.flush();
        writer.close();
    }
}
