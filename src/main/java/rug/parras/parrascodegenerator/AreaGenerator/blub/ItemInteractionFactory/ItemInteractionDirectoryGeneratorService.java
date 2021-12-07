package rug.parras.parrascodegenerator.AreaGenerator.blub.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.AreaGenerator.blub.AreaGeneratorInterfaces.DirectoryGenerator;

import java.io.File;

@Service
public class ItemInteractionDirectoryGeneratorService implements DirectoryGenerator {

    ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator;

    @Autowired
    public ItemInteractionDirectoryGeneratorService(ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator) {
        this.itemInteractionFactoryDirectoryPathGenerator = itemInteractionFactoryDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(itemInteractionFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdir();
    }
}
