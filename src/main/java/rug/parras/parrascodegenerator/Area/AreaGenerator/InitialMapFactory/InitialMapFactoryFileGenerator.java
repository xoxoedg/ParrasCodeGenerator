package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;
import java.io.IOException;

@Component
public class InitialMapFactoryFileGenerator implements FactoryFileGenerator {

    InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    @Autowired
    public InitialMapFactoryFileGenerator(InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator) {
        this.initialMapFactoryFilepathGenerator = initialMapFactoryFilepathGenerator;
    }

    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(initialMapFactoryFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}
