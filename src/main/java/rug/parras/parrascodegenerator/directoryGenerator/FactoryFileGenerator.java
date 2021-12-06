package rug.parras.parrascodegenerator.directoryGenerator;

import java.io.File;

public interface FactoryFileGenerator {

    String generateFilename(String areaName);

    File createFile(String areaName);
}
