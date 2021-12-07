package rug.parras.parrascodegenerator.AreaGenerator.blub.BattleFactory;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class BattleFactoryService {

    public void writeToFile(String areaName) throws IOException {
        BattleFactoryFileGenerator battleFactoryFileGenerator = new BattleFactoryFileGenerator();
        BattleFactoryCodeGenerator battleFactoryCodeGenerator = new BattleFactoryCodeGenerator();
        FileWriter writer = new FileWriter(battleFactoryFileGenerator.createFile(areaName));
        writer.write(battleFactoryCodeGenerator.generateFactoryCode(areaName));
    }
}
