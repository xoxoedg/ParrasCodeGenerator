package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.SignInteractionController;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.SignInteractionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class SignInteractionControllerTest {

    @Mock
    private SignInteractionService signInteractionService;

    @InjectMocks
    private SignInteractionController signInteractionController;

    @Test
    void getSignPage() throws Exception {
        MockMvc mvcController = MockMvcBuilders.standaloneSetup(signInteractionController).build();
        mvcController.perform(get("/sign"))
                .andExpect(status().isOk())
                .andExpect(view().name("signGeneratorPage"))
                .andExpect(model().attribute("signInteraction", Matchers.any(Sign.class)));
    }

    @Test
    void signSubmit() throws Exception {
        MockMvc mvcController = MockMvcBuilders.standaloneSetup(signInteractionController).build();
        mvcController.perform(post("/sign"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(signInteractionService, times(1)).createSignInteraction(any(Sign.class));
    }
}