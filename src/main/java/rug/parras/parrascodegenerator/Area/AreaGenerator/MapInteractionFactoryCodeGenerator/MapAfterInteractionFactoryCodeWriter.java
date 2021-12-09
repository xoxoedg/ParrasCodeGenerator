package rug.parras.parrascodegenerator.Area.AreaGenerator.MapInteractionFactoryCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Area.FileOperations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class MapAfterInteractionFactoryCodeWriter implements CodeWriterGenerator {

    MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator;

    MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator;

    @Autowired
    public MapAfterInteractionFactoryCodeWriter(MapAfterInteractionFactoryFilepathGenerator mapAfterInteractionFactoryFilepathGenerator, MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator) {
        this.mapAfterInteractionFactoryFilepathGenerator = mapAfterInteractionFactoryFilepathGenerator;
        this.mapAfterInteractionFactoryCodeGenerator = mapAfterInteractionFactoryCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File mapAfterInteractionFactoryPythonFile = new File(mapAfterInteractionFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperations.checkIfFileIsEmpty(mapAfterInteractionFactoryPythonFile)) {
            FileOperations.writeToFile(mapAfterInteractionFactoryCodeGenerator.generateFactoryCode(areaName), mapAfterInteractionFactoryPythonFile);
        }
    }
}