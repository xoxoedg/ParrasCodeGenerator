package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PythonCodeGenerationServiceTest {

    private final String builtCodeTemplate =
            "from common.dialogs.abstract_interaction_dialog import AbstractInteractionDialog\n" +
                    "\n" +
                    "\n" +
                    "SIGN_UP_INTERACTION_CITYMARKET_DIALOG = ['Danger']\n" +
                    "\n" +
                    "\n" +
                    "class SignUpInteractionCityMarket(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(SignUpInteractionCityMarket, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return SIGN_UP_INTERACTION_CITYMARKET_DIALOG.copy()";

    private final PythonCodeGenerationService pythonCodeGenerationService = new PythonCodeGenerationService();
    private Sign sign;

    @Test
    void pythonCodeBuilder() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("CityMarket")
                .direction("Up")
                .fileName("signInteraction.py").build();

        String builtCode = pythonCodeGenerationService.pythonCodeBuilder(sign);
        assertEquals(builtCodeTemplate, builtCode);

    }
}