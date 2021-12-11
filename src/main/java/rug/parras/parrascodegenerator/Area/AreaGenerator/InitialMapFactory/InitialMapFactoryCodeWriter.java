package rug.parras.parrascodegenerator.Area.AreaGenerator.InitialMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

@Component
public class InitialMapFactoryCodeWriter implements CodeWriterGenerator {

    InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator;

    InitialMapFactoryCodeGenerator initialMapFactoryCodeGenerator;

    @Autowired
    public InitialMapFactoryCodeWriter(InitialMapFactoryFilepathGenerator initialMapFactoryFilepathGenerator, InitialMapFactoryCodeGenerator initialMapFactoryCodeGenerator) {
        this.initialMapFactoryFilepathGenerator = initialMapFactoryFilepathGenerator;
        this.initialMapFactoryCodeGenerator = initialMapFactoryCodeGenerator;
    }

    @Override
    public void writeToFile(String areaName) throws IOException {
        File initialMapFactoryPythonFile = new File(initialMapFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperationsUtils.checkIfFileIsEmpty(initialMapFactoryPythonFile)) {
            FileOperationsUtils.writeToFile(initialMapFactoryCodeGenerator.generateFactoryCode(areaName), initialMapFactoryPythonFile);
        }

    }
}


