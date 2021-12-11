package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.DirectoryGenerator;

import java.io.File;

@Service
public class ItemInteractionDirectoryGeneratorService implements DirectoryGenerator {

    private final ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator;

    @Autowired
    public ItemInteractionDirectoryGeneratorService(ItemInteractionFactoryDirectoryPathGenerator itemInteractionFactoryDirectoryPathGenerator) {
        this.itemInteractionFactoryDirectoryPathGenerator = itemInteractionFactoryDirectoryPathGenerator;
    }

    @Override
    public void createDirectories(String areaName) {
        File directory = new File(itemInteractionFactoryDirectoryPathGenerator.createDirectoryPath(areaName));
        directory.mkdirs();
    }
}
