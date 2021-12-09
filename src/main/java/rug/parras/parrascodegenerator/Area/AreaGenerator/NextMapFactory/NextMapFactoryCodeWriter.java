package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;
import rug.parras.parrascodegenerator.Area.FileOperations;

import java.io.File;
import java.io.IOException;

@Component
public class NextMapFactoryCodeWriter implements CodeWriterGenerator {

    NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;

    NextMapFactoryCodeGenerator nextMapFactoryCodeGenerator;

    @Autowired
    public NextMapFactoryCodeWriter(NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator, NextMapFactoryCodeGenerator nextMapFactoryCodeGenerator) {
        this.nextMapFactoryFilepathGenerator = nextMapFactoryFilepathGenerator;
        this.nextMapFactoryCodeGenerator = nextMapFactoryCodeGenerator;
    }


    @Override
    public void writeToFile(String areaName) throws IOException {
        File nextMapFactoryPythonFile = new File(nextMapFactoryFilepathGenerator.generateFilename(areaName));
        if (FileOperations.checkIfFileIsEmpty(nextMapFactoryPythonFile)) {
            FileOperations.writeToFile(nextMapFactoryCodeGenerator.generateFactoryCode(areaName), nextMapFactoryPythonFile);
        }
    }
}
