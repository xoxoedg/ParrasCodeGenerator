package rug.parras.parrascodegenerator.Utils;

import java.io.IOException;

public interface CodeConverter {

    String createFile() throws IOException;

    void writeToFile(String pythonCode) throws IOException;
}
