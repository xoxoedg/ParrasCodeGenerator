package rug.parras.parrascodegenerator.AreaGenerator.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ItemInteractionDirectoryGeneratorService {

    ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator;

    @Autowired
    public ItemInteractionDirectoryGeneratorService(ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator) {
        this.itemInteractionFactoryDirectoryPathGenerator = itemInteractionFactoryDirectoryPathGenerator;
    }

    public void createDirectories(String areaName) {
        File directory = new File(itemInteractionFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
