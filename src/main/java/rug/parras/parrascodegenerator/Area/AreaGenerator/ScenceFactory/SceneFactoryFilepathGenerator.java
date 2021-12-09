package rug.parras.parrascodegenerator.Area.AreaGenerator.ScenceFactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFilepathGenerator;
import rug.parras.parrascodegenerator.Area.AreaGenerator.GamePath;


@Getter
@Setter
@Component
public class SceneFactoryFilepathGenerator extends GamePath implements FactoryFilepathGenerator {

    private static final String SCENE_FACTORY_FILE_TEMPLATE = "%s\\src\\characters\\scenes\\%s\\%s_scene_factory.py";

    @Override
    public String generateFilename(String areaName) {
        return String.format(SCENE_FACTORY_FILE_TEMPLATE, path, areaName.toLowerCase(), areaName.toLowerCase());
    }
}
