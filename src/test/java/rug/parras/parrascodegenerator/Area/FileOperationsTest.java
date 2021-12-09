package rug.parras.parrascodegenerator.Area;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    private final String filepath = "C:\\Users\\rugya\\Desktop\\Prod\\ParrasCodeGenerator\\src\\test\\codeGeneratorTest\\src\\characters\\battles\\Rionnagen\\rionnagen_battle_factory.py";


    @BeforeEach
    void setUp() {
    }

    @Test
    void writeToFile() {
    }

    @Test
    void checkIfFileIsEmpty() {
        String filepath = "C:\\Users\\rugya\\Desktop\\Prod\\ParrasCodeGenerator\\src\\test\\codeGeneratorTest\\src\\characters\\battles\\Rionnagen\\rionnagen_battle_factory.py";
        assertFalse(FileOperations.checkIfFileIsEmpty(new File(filepath)));
    }

    @Test
    void checkIfFileExist() {
        assertTrue(FileOperations.checkIfFileExist(filepath));
    }
}