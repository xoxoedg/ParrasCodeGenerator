package rug.parras.parrascodegenerator.AreaGenerator.MapInteractionFactoryCodeGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class MapAfterInteractionFactoryService {

    public void writeToFile(String areaName) throws IOException {
        MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator = new MapAfterInteractionFactoryCodeGenerator();
        MapAfterInteractionFactoryFileGenerator mapAfterInteractionFactoryFileGenerator = new MapAfterInteractionFactoryFileGenerator();
        FileWriter writer = new FileWriter(mapAfterInteractionFactoryFileGenerator.generateFilename(areaName));
        writer.write(mapAfterInteractionFactoryCodeGenerator.generateFactoryCode(areaName));
    }
}
