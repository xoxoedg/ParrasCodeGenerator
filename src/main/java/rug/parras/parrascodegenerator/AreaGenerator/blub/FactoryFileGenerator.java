package rug.parras.parrascodegenerator.AreaGenerator.blub;

import java.io.File;

public interface FactoryFileGenerator {

    String generateFilename(String areaName);

    File createFile(String areaName);
}
