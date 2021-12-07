package rug.parras.parrascodegenerator.AreaGenerator.blub.InitialMapFactory;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class InitialMapFactoryService {

    public void writeToFile(String areaName) throws IOException {
        InitialMapFactoryCodeGenerator initialMapFactoryCodeGenerator = new InitialMapFactoryCodeGenerator();
        InitialMapFactoryFileGenerator initialMapFactoryFileGenerator = new InitialMapFactoryFileGenerator();
        FileWriter writer = new FileWriter(initialMapFactoryFileGenerator.createFile(areaName));
        writer.write(initialMapFactoryCodeGenerator.generateFactoryCode(areaName));
    }
}

