package rug.parras.parrascodegenerator.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rug.parras.parrascodegenerator.Map.Validation.MapValidationService;
import rug.parras.parrascodegenerator.Map.Validation.ValidationResult;
import rug.parras.parrascodegenerator.common.ValidationStatus;

import java.io.File;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MapServiceTest {

    @Mock
    MapCodeGenerationService mapCodeGenerationService;

    @Mock
    MapValidationService mapValidationService;

    @InjectMocks
    MapService mapService;

    @Test
    void createMap() {
        Map map = new Map();
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidationStatus(ValidationStatus.SUCCESS);
        map.setFilename("mapgenerator.py");
        when(mapCodeGenerationService.generateMap(map)).thenReturn("Test123");
        when(mapValidationService.validateInput(map)).thenReturn(validationResult);
        mapService.createMap(map);
        verify(mapCodeGenerationService).generateMap(map);
        verify(mapValidationService).validateInput(map);

        File fileToDelete = new File("testPythonDir/mapgenerator.py");
        fileToDelete.delete();

    }
}