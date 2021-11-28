package rug.parras.parrascodegenerator.Utils;

import java.io.IOException;

public interface CodeConverter {

    String createFile(String fileName) throws IOException;

    void writeToFile(String pythonCode) throws IOException;
}
