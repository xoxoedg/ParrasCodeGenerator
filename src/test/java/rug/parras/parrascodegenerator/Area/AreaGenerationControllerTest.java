package rug.parras.parrascodegenerator.Area;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rug.parras.parrascodegenerator.Area.AreaGenerator.Area;
import rug.parras.parrascodegenerator.Area.Validation.ValidationIOResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AreaGenerationControllerTest {

    @Mock
    private AreaGenerationService areaGenerationService;

    @InjectMocks
    private AreaGenerationController areaGenerationController;

    @Test
    void getAreaPage() throws Exception {
        MockMvc controller = MockMvcBuilders.standaloneSetup(areaGenerationController).build();
        controller.perform(get("/area"))
                .andExpect(status().isOk())
                .andExpect(view().name("areaGenerator"))
                .andExpect(model().attribute("area", Matchers.any(Area.class)));
    }

    @Test
    void areaSubmit() throws Exception {
        ValidationIOResult validationResult = new ValidationIOResult();
        validationResult.setUrl("areaGeneratorResult");
        MockMvc controller = MockMvcBuilders.standaloneSetup(areaGenerationController).build();
        when(areaGenerationService.createArea(any(Area.class))).thenReturn(validationResult);
        controller.perform(post("/area"))
                .andExpect(status().isOk())
                .andExpect(view().name("areaGeneratorResult"));

        verify(areaGenerationService).createArea(any(Area.class));
    }

    @Test
    void areaSubmitError() throws Exception {
        ValidationIOResult validationResult = new ValidationIOResult();
        validationResult.setUrl("error");
        MockMvc controller = MockMvcBuilders.standaloneSetup(areaGenerationController).build();
        when(areaGenerationService.createArea(any(Area.class))).thenReturn(validationResult);
        controller.perform(post("/area"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attribute("errorReasons", Matchers.any(ValidationIOResult.class)));

        verify(areaGenerationService).createArea(any(Area.class));
    }
}