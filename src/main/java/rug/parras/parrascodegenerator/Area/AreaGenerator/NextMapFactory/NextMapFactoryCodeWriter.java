package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.CodeWriterGenerator;

import java.io.File;
import java.io.FileWriter;
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
        File nextMapFactoryPythonNFile = new File(nextMapFactoryFilepathGenerator.generateFilename(areaName));
        FileWriter writer = new FileWriter(nextMapFactoryPythonNFile);
        writer.write(nextMapFactoryCodeGenerator.generateFactoryCode(areaName));
        writer.flush();
        writer.close();
    }
}
