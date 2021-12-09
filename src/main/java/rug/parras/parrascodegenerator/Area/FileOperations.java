package rug.parras.parrascodegenerator.Area;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {

    public static void writeToFile(String codeToWrite, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(codeToWrite);
        writer.flush();
        writer.close();
    }

    public static boolean checkIfFileIsEmpty(File file) {
        return file.length() == 0;
    }

    public static boolean checkIfFileExist(String filepath) {
        return new File(filepath).exists();
    }
}
