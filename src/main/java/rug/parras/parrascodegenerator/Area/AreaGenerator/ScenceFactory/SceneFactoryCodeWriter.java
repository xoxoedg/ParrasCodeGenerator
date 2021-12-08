package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SceneFactoryCodeWriter implements CodeWriterGenerator {

    SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;
    SceneFactoryCodeGenerator sceneFactoryCodeGenerator;

    @Autowired
    public SceneFactoryCodeWriter(SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator, SceneFactoryCodeGenerator sceneFactoryCodeGenerator) {
        this.sceneFactoryFilepathGenerator = sceneFactoryFilepathGenerator;
        this.sceneFactoryCodeGenerator = sceneFactoryCodeGenerator;
    }

    @Override
    public void writeToFile(String areaName) throws IOException {
        File sceneFactoryPythonFile = new File(sceneFactoryFilepathGenerator.generateFilename(areaName));
        FileWriter writer = new FileWriter(sceneFactoryPythonFile);
        writer.write(sceneFactoryCodeGenerator.generateFactoryCode(areaName));
        writer.flush();
        writer.close();
    }
}
