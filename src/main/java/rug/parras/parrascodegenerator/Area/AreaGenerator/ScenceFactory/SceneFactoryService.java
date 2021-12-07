package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class SceneFactoryService {

    public void writeToFile(String areaName) throws IOException {
        SceneFactoryCodeGenerator sceneFactoryCodeGenerator = new SceneFactoryCodeGenerator();
        SceneFactoryFileGenerator sceneFactoryFileGenerator = new SceneFactoryFileGenerator();
        FileWriter writer = new FileWriter(sceneFactoryFileGenerator.createFile(areaName));
        writer.write(sceneFactoryCodeGenerator.generateFactoryCode(areaName));


    }
}
