package rug.parras.parrascodegenerator.AreaGenerator.ScenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SceneFactoryDirectoryGeneratorService {

    ScenceFactoryDirectoryPathGenerator scenceFactoryDirectoryPathGenerator;

    @Autowired
    public SceneFactoryDirectoryGeneratorService(ScenceFactoryDirectoryPathGenerator scenceFactoryDirectoryPathGenerator) {
        this.scenceFactoryDirectoryPathGenerator = scenceFactoryDirectoryPathGenerator;
    }

    public void createDirectories(String areaName) {
        File directory = new File(scenceFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
