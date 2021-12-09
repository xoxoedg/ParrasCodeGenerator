package rug.parras.parrascodegenerator.Area.Validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Area.AreaGenerator.BattleFactory.BattleFactoryFilepathGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidationIOServiceTest {

    @Mock
    BattleFactoryFilepathGenerator battleFactoryFilepathGenerator;

    @InjectMocks
    ValidationIOService validationIOService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void checkIfBattleFactoryFileExist() {
    }
}