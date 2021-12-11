package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Component
public class SceneFactoryCodeWriter implements CodeWriterGenerator {

    private final SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;
    private final SceneFactoryCodeGenerator sceneFactoryCodeGenerator;

    @Autowired
    public SceneFactoryCodeWriter(SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator, SceneFactoryCodeGenerator sceneFactoryCodeGenerator) {
        this.sceneFactoryFilepathGenerator = sceneFactoryFilepathGenerator;
        this.sceneFactoryCodeGenerator = sceneFactoryCodeGenerator;
    }

    @Override
    public void writeToFile(String areaName) throws IOException {
        File sceneFactoryPythonFile = new File(sceneFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperationsUtils.checkIfFileIsEmpty(sceneFactoryPythonFile)) {
            FileOperationsUtils.writeToFile(sceneFactoryCodeGenerator.generateFactoryCode(areaName), sceneFactoryPythonFile);
        }
    }
}
