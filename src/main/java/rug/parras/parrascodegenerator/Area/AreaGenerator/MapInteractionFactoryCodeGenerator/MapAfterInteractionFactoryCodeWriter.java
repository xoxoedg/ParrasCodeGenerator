package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Component
public class MapAfterInteractionFactoryCodeWriter implements CodeWriterGenerator {

    private final MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    private final MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator;

    @Autowired
    public MapAfterInteractionFactoryCodeWriter(MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator, MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator) {
        this.mapAfterInteractionFactoryFilepathGenerator = mapAfterInteractionFactoryFilepathGenerator;
        this.mapAfterInteractionFactoryCodeGenerator = mapAfterInteractionFactoryCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File mapAfterInteractionFactoryPythonFile = new File(mapAfterInteractionFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperationsUtils.checkIfFileIsEmpty(mapAfterInteractionFactoryPythonFile)) {
            FileOperationsUtils.writeToFile(mapAfterInteractionFactoryCodeGenerator.generateFactoryCode(areaName), mapAfterInteractionFactoryPythonFile);
        }
    }
}
