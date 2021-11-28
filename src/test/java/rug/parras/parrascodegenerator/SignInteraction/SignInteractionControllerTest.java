package rug.parras.parrascodegenerator.SignInteraction;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class SignInteractionControllerTest {

    @Mock
    SignInteractionService signInteractionService;

    @InjectMocks
    SignInteractionController signInteractionController;

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
    }
}