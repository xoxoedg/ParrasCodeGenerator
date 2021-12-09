package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BattleFactoryCodeGeneratorWriterTest {

    @Mock
    BattleFactoryCodeGenerator battleFactoryCodeGenerator;

    @Mock
    BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;

    @InjectMocks
    BattleFactoryCodeGeneratorWriter battleFactoryCodeGeneratorWriter;

    @Test
    void writeToFile() throws IOException {
        File fileToDelete = new File("Rionnagen.py");
        when(battleFactoryCodeGenerator.generateFactoryCode(anyString())).thenReturn("123");
        when(battleFactoryFilepathGenerator.generateFilename(anyString())).thenReturn("Rionnagen.py");
        battleFactoryCodeGeneratorWriter.writeToFile("Rionnagen");
        verify(battleFactoryFilepathGenerator).generateFilename("Rionnagen");
        verify(battleFactoryCodeGenerator).generateFactoryCode("Rionnagen");
        fileToDelete.delete();

    }

}