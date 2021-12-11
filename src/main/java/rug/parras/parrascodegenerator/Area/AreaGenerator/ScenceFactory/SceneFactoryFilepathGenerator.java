package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;
import rug.parras.parrascodegenerator.Utils.StringOperationUtils;

@Component
public class SceneFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String SCENE_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\scenes\\%s\\%s_scene_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(SCENE_FACTORY_FILE_TEMPLATE, path, StringOperationUtils.convertSpaceToLowercase(areaName),
                StringOperationUtils.convertSpaceToLowercaseAndUnderscore(areaName));
    }
}
