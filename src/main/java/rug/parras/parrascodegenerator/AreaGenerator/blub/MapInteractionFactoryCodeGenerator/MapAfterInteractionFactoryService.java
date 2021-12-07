package rug.parras.parrascodegenerator.AreaGenerator.blub.MapInteractionFactoryCodeGenerator;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class MapAfterInteractionFactoryService {

    public void writeToFile(String areaName) throws IOException {
        MapAfterInteractionFactoryCodeGenerator mapAfterInteractionFactoryCodeGenerator = new MapAfterInteractionFactoryCodeGenerator();
        MapAfterInteractionFactoryFileGenerator mapAfterInteractionFactoryFileGenerator = new MapAfterInteractionFactoryFileGenerator();
        FileWriter writer = new FileWriter(mapAfterInteractionFactoryFileGenerator.generateFilename(areaName));
        writer.write(mapAfterInteractionFactoryCodeGenerator.generateFactoryCode(areaName));
    }
}
