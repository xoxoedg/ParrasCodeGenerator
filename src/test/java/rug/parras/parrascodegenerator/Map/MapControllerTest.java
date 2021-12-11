package rug.parras.parrascodegenerator.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rug.parras.parrascodegenerator.Map.Validation.ValidationResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MapControllerTest {

    @Mock
    private MapService mapService;

    @InjectMocks
    private MapController mapController;

    @Test
    void getMapPage() throws Exception {
        MockMvc controller = MockMvcBuilders.standaloneSetup(mapController).build();
        controller.perform(get("/map"))
                .andExpect(status().isOk())
                .andExpect(view().name("mapGenerator"))
                .andExpect(model().attribute("generatedMap", Matchers.any(Map.class)));
    }

    @Test
    void mapSubmit() throws Exception {
        MockMvc controller = MockMvcBuilders.standaloneSetup(mapController).build();
        ValidationResult validationResult = new ValidationResult();
        validationResult.setUrl("index");
        when(mapService.createMap(any(Map.class))).thenReturn(validationResult);
        controller.perform(post("/map"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(mapService).createMap(any(Map.class));
    }

    @Test
    void mapSubmitError() throws Exception {
        MockMvc controller = MockMvcBuilders.standaloneSetup(mapController).build();
        ValidationResult validationResult = new ValidationResult();
        validationResult.setUrl("mapError");
        when(mapService.createMap(any(Map.class))).thenReturn(validationResult);
        controller.perform(post("/map"))
                .andExpect(status().isOk())
                .andExpect(view().name("mapError"))
                .andExpect(model().attribute("errorReasons", Matchers.any(ValidationResult.class)));

        verify(mapService).createMap(any(Map.class));
    }
}