package rug.parras.parrascodegenerator.Utils;

import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Getter
public class GeneratedCodeToFileConverter implements CodeConverter{

    private File file;
    Writer writer;

    public GeneratedCodeToFileConverter(Writer writer) {
        this.writer = writer;
    }

    public String createFile(String fileName) throws IOException {
        file = new File(fileName);
        if (file.createNewFile()) {
            return "File created" + file.getCanonicalPath();
        }
        return "File already exists";
    }

    public void writeToFile(String pythonCode) throws IOException {
        writer.write(pythonCode);

    };

    public void appendToFile(String pythonCode) throws  IOException {
        writer.append("\n\n" + pythonCode);
        writer.flush();
        writer.close();
    }
}
