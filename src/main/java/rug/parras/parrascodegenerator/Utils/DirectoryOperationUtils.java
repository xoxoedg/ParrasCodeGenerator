package rug.parras.parrascodegenerator.Utils;

import java.io.File;

public class DirectoryOperationUtils {

    public void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        } else return;
    }
}
