package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rug.parras.parrascodegenerator.Interactions.Validation.InteractionValidationStatus;
import rug.parras.parrascodegenerator.Interactions.Validation.ValidationResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
        ValidationResult validationResult = new ValidationResult();
        validationResult.setUrl("index");
        MockMvc mvcController = MockMvcBuilders.standaloneSetup(signInteractionController).build();
        validationResult.setInteractionValidationStatus(InteractionValidationStatus.SUCCESS);
        when(signInteractionService.createSignInteraction(any(Sign.class))).thenReturn(validationResult);
        mvcController.perform(post("/sign"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(signInteractionService).createSignInteraction(any(Sign.class));
    }

    @Test
    void signSubmitError() throws Exception {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setUrl("error");
        MockMvc mvcController = MockMvcBuilders.standaloneSetup(signInteractionController).build();
        validationResult.setInteractionValidationStatus(InteractionValidationStatus.SUCCESS);
        when(signInteractionService.createSignInteraction(any(Sign.class))).thenReturn(validationResult);
        mvcController.perform(post("/sign"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attribute("errorReasons", Matchers.any(ValidationResult.class)));

        verify(signInteractionService).createSignInteraction(any(Sign.class));
    }
}