package rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces;

import java.io.IOException;

public interface FactoryFileGenerator {

    String generateFilename(String areaName);

    boolean createFile(String areaName) throws IOException;
}
