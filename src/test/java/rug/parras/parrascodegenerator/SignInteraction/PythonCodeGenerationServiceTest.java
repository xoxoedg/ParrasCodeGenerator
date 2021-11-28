package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PythonCodeGenerationServiceTest {
    private final String generatedPythonCodeTemplate =
            "class SignUpInteractionCityMarket(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(SignUpInteractionCityMarket, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return SIGN_UP_INTERACTION_CITYMARKET_DIALOG.copy()";

    PythonCodeGenerationService pythonCodeGenerationService = new PythonCodeGenerationService();
    Sign sign;


    @Test
    void createList() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("CityMarket")
                .direction("Up")
                .fileName("signInteraction.py").build();

        String createdList = pythonCodeGenerationService.createList(sign);
        assertEquals("SIGN_UP_INTERACTION_CITYMARKET_DIALOG = ['Danger']", createdList);

    }

    @Test
    void createListName() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("CityMarket")
                .direction("Up")
                .fileName("signInteraction.py").build();

        String listName = pythonCodeGenerationService.createListName(sign);
        assertEquals("SIGN_UP_INTERACTION_CITYMARKET_DIALOG", listName);

    }

    @Test
    void CreatePythonCode() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("CityMarket")
                .direction("Up")
                .fileName("signInteraction.py").build();

        String generatedPythonCode = pythonCodeGenerationService.createPythonCode(sign);
        assertEquals(generatedPythonCodeTemplate, generatedPythonCode);
    }
}