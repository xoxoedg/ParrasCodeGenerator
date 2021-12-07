package rug.parras.parrascodegenerator.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SceneFactoryDirectoryGeneratorService {

    public void createDirectories(String areaName) {
        ScenceFactoryDirectoryPathGenerator scenceFactoryDirectoryPathGenerator = new ScenceFactoryDirectoryPathGenerator();
        File directory = new File(scenceFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
