package rug.parras.parrascodegenerator.AreaGenerator.blub.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.blub.AreaGeneratorInterfaces.DirectoryGenerator;

import java.io.File;

@Service
public class SceneFactoryDirectoryGeneratorService implements DirectoryGenerator {

    SceneFactoryDirectoryPathGenerator sceneFactoryDirectoryPathGenerator;

    @Autowired
    public SceneFactoryDirectoryGeneratorService(SceneFactoryDirectoryPathGenerator sceneFactoryDirectoryPathGenerator) {
        this.sceneFactoryDirectoryPathGenerator = sceneFactoryDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(sceneFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
