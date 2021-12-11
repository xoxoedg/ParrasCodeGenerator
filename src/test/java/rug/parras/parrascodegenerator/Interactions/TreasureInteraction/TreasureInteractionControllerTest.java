package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class TreasureInteractionControllerTest {

    @Mock
    private TreasureInteractionService treasureInteractionService;

    @InjectMocks
    private TreasureInteractionController treasureInteractionController;


    @Test
    void getTreasurePage() throws Exception {
        MockMvc mvcControllerGet = MockMvcBuilders.standaloneSetup(treasureInteractionController).build();
        mvcControllerGet.perform(get("/treasure"))
                .andExpect(status().isOk())
                .andExpect(view().name("treasureGeneratorPage"))
                .andExpect(model().attribute("treasureInteraction", Matchers.any(Treasure.class)));

    }

    @Test
    void treasureSubmit() throws Exception {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setUrl("index");
        MockMvc mvcControllerPost = MockMvcBuilders.standaloneSetup(treasureInteractionController).build();
        when(treasureInteractionService.createTreasureInteraction(any(Treasure.class))).thenReturn(validationResult);
        mvcControllerPost.perform(post("/treasure"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(treasureInteractionService).createTreasureInteraction(any(Treasure.class));
    }
}