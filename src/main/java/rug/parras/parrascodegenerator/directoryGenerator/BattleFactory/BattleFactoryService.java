package rug.parras.parrascodegenerator.directoryGenerator.BattleFactory;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class BattleFactoryService {

    public void writeToFile() throws IOException {
        BattleFactoryFileGenerator battleFactoryFileGenerator = new BattleFactoryFileGenerator();
        BattleFactoryCodeGenerator battleFactoryCodeGenerator = new BattleFactoryCodeGenerator();
        FileWriter writer = new FileWriter(battleFactoryFileGenerator.createFile());
        writer.write(battleFactoryCodeGenerator.generateBattleFactoryCode());
    }
}
