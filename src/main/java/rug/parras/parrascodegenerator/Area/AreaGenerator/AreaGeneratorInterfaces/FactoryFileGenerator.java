package rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces;

import rug.parras.parrascodegenerator.Area.Validation.ValidationFileResult;

import java.io.IOException;

public interface FactoryFileGenerator {

    ValidationFileResult createFile(String areaName) throws IOException;
}
