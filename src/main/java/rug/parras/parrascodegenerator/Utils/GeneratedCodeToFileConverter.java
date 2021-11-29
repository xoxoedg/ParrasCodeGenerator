package rug.parras.parrascodegenerator.Utils;

import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Getter
public class GeneratedCodeToFileConverter implements CodeConverter{

    private String filename;
    private File file;

    public GeneratedCodeToFileConverter(String filename) {
        this.filename = filename;
        this.file = new File(filename);
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

    };
}
