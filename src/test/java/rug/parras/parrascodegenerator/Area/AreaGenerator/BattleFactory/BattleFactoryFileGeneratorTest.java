package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BattleFactoryFileGeneratorTest {

    @Mock
    BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;

    @InjectMocks
    BattleFactoryFileGenerator battleFactoryFileGenerator;


    @Test
    void createFile() throws IOException {
        when(battleFactoryFilepathGenerator.generateFilename(anyString())).thenReturn("hello.py");
        battleFactoryFileGenerator.createFile("hello.py");
        verify(battleFactoryFilepathGenerator).generateFilename("hello.py");
        File fileToDelete = new File("hello.py");
        fileToDelete.delete();

    }
}