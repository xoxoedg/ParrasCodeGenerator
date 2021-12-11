package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryGenerator;

import java.io.File;

@Service
public class SceneFactoryDirectoryGeneratorService implements DirectoryGenerator {

    private final SceneFactoryDirectoryPathGenerator sceneFactoryDirectoryPathGenerator;

    @Autowired
    public SceneFactoryDirectoryGeneratorService(SceneFactoryDirectoryPathGenerator sceneFactoryDirectoryPathGenerator) {
        this.sceneFactoryDirectoryPathGenerator = sceneFactoryDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(sceneFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        File subConversationDirectory = new File(sceneFactoryDirectoryPathGenerator.createSubDirectoryConversationsPath(areaName));
        File subSceneDirectory = new File(sceneFactoryDirectoryPathGenerator.createSubDirectoryScenesPath(areaName));
        directory.mkdirs();
        subConversationDirectory.mkdirs();
        subSceneDirectory.mkdirs();
    }
}
