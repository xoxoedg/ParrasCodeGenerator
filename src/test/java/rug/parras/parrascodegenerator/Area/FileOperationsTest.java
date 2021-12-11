package rug.parras.parrascodegenerator.Area;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOperationsTest {
    File file;

    @Test
    void checkIfFileIsEmpty() throws IOException {
        file = new File("test");
        String testInput = "wuff";
        FileOperations.writeToFile(testInput, file);
        assertFalse(FileOperations.checkIfFileIsEmpty(file));
        file.delete();
    }

    @Test
    void checkIfFileExist() throws IOException {
        file = new File("test");
        file.createNewFile();
        assertTrue(FileOperations.checkIfFileExist("test"));
        file.delete();
    }
}