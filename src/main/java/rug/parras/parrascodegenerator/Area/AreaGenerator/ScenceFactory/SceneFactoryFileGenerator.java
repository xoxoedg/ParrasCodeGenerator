package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;
import java.io.IOException;

@Component
public class SceneFactoryFileGenerator implements FactoryFileGenerator {

    SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator;

    @Autowired
    public SceneFactoryFileGenerator(SceneFactoryFilepathGenerator sceneFactoryFilepathGenerator) {
        this.sceneFactoryFilepathGenerator = sceneFactoryFilepathGenerator;
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(sceneFactoryFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}
