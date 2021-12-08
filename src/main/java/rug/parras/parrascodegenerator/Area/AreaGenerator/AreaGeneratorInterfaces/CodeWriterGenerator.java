package rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces;

import java.io.IOException;

public interface CodeWriterGenerator {
    void writeToFile(String areaName) throws IOException;
}
