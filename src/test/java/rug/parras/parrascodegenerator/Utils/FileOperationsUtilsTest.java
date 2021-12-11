package rug.parras.parrascodegenerator.Utils;

import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Utils.FileOperationsUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOperationsUtilsTest {
    File file;

    @Test
    void checkIfFileIsEmpty() throws IOException {
        file = new File("test");
        String testInput = "wuff";
        FileOperationsUtils.writeToFile(testInput, file);
        assertFalse(FileOperationsUtils.checkIfFileIsEmpty(file));
        file.delete();
    }

    @Test
    void checkIfFileExist() throws IOException {
        file = new File("test");
        file.createNewFile();
        assertTrue(FileOperationsUtils.checkIfFileExist("test"));
        file.delete();
    }
}