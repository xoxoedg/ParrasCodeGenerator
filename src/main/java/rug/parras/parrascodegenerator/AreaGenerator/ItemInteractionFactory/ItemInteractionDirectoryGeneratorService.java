package rug.parras.parrascodegenerator.AreaGenerator.ItemInteractionFactory;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ItemInteractionDirectoryGeneratorService {


    public void createDirectories(String areaName) {
        ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator = new ItemInteractionFactoryDirectoryPathGenerator();
        File directory = new File(itemInteractionFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
