package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;
import java.io.IOException;

@Component
public class MapAfterInteractionFactoryFileGenerator implements FactoryFileGenerator {

    MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    @Autowired
    public MapAfterInteractionFactoryFileGenerator(MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator) {
        this.mapAfterInteractionFactoryFilepathGenerator = mapAfterInteractionFactoryFilepathGenerator;
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(mapAfterInteractionFactoryFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}
