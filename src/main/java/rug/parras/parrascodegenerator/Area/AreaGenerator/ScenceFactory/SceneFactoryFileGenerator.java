package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;

import java.io.File;
import java.io.IOException;

@Component
public class SceneFactoryFileGenerator extends GamePath implements FactoryFileGenerator {

    private static final String SCENE_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\scenes\\%s\\%s_item_interaction_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(SCENE_FACTORY_FILE_TEMPLATE, path, areaName, areaName);
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(generateFilename(areaName)).createNewFile();
    }
}
