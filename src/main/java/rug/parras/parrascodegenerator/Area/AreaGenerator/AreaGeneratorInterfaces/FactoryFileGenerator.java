package rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces;

import java.io.File;

public interface FactoryFileGenerator {

    String generateFilename(String areaName);

    File createFile(String areaName);
}
