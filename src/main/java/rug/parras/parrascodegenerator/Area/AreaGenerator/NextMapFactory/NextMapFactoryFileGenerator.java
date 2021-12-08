package rug.parras.parrascodegenerator.Area.AreaGenerator.NextMapFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryFileGenerator;

import java.io.File;
import java.io.IOException;

@Component
public class NextMapFactoryFileGenerator implements FactoryFileGenerator {

    NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator;

    @Autowired
    public NextMapFactoryFileGenerator(NextMapFactoryFilepathGenerator nextMapFactoryFilepathGenerator) {
        this.nextMapFactoryFilepathGenerator = nextMapFactoryFilepathGenerator;
    }


    @Override
    public boolean createFile(String areaName) throws IOException {
        return new File(nextMapFactoryFilepathGenerator.generateFilename(areaName)).createNewFile();
    }
}
