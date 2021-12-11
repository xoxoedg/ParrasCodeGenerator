package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Component
public class BattleFactoryCodeGeneratorWriter implements CodeWriterGenerator {

    private final BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;
    private final BattleFactoryCodeGenerator battleFactoryCodeGenerator;

    @Autowired
    public BattleFactoryCodeGeneratorWriter(BattleFactoryFilepathGenerator battleFactoryFilepathGenerator,
                                            BattleFactoryCodeGenerator battleFactoryCodeGenerator) {
        this.battleFactoryFilepathGenerator = battleFactoryFilepathGenerator;
        this.battleFactoryCodeGenerator = battleFactoryCodeGenerator;
    }

    @Override
    public void writeToFile(String areaName) throws IOException {
        File battleFactoryPythonFile = new File(battleFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperationsUtils.checkIfFileIsEmpty(battleFactoryPythonFile)) {
            FileOperationsUtils.writeToFile(battleFactoryCodeGenerator.generateFactoryCode(areaName), battleFactoryPythonFile);
        }
    }
}
