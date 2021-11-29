package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignInteractionCodeGenerationServiceTest {

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

    private final SignInteractionCodeGenerationService signInteractionCodeGenerationService = new SignInteractionCodeGenerationService();
    private Sign sign;

    @Test
    void pythonCodeBuilder() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("CityMarket")
                .direction("Up")
                .fileName("signInteraction.py").build();

        String builtCode = signInteractionCodeGenerationService.generateCodeForSignInteraction(sign);
        assertEquals(builtCodeTemplate, builtCode);

    }
}