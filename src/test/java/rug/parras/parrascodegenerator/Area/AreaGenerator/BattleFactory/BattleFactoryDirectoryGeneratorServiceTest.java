package rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("it")

@ExtendWith(MockitoExtension.class)
class BattleFactoryDirectoryGeneratorServiceTest {
    @Mock
    BattleFactoryDirectoryPathGenerator battleFactoryDirectoryPathGenerator;
    @InjectMocks
    BattleFactoryDirectoryGeneratorService battleFactoryDirectoryGeneratorService;

    @Test
    void createDirectories() {
        File directoryToDelete = new File("wufft");
        when(battleFactoryDirectoryPathGenerator.createDirectoryPath(anyString())).thenReturn("Wufft");
        battleFactoryDirectoryGeneratorService.createDirectories("Wufft");
        verify(battleFactoryDirectoryPathGenerator).createDirectoryPath("Wufft");
        directoryToDelete.delete();
    }
}