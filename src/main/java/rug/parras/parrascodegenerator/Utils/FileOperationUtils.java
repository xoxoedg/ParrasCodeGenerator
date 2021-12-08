package rug.parras.parrascodegenerator.Utils;

import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Getter
public class FileOperationUtils {

    private final String filePath;
    private final File file;

    public FileOperationUtils(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public String createFile() throws IOException {
        if (file.createNewFile()) {
            return "File created";
        }
        return "File already exists";
    }

    public void writeToFile(String pythonCode) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(pythonCode);
        writer.flush();
        writer.close();
    }

    public static void writeCodeToFile(String Code, String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        writer.write(Code);
        writer.flush();
        writer.close();
    }
}
