package rug.parras.parrascodegenerator.SignInteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignInteractionCodeGenerationServiceTest {

    private final String builtCodeTemplate =
            "from common.dialogs.abstract_interaction_dialog import AbstractInteractionDialog\n" +
                    "\n" +
                    "\n" +
                    "SIGN_UP_INTERACTION_CITY_MARKET_MAP_DIALOG = ['Danger']\n" +
                    "\n" +
                    "\n" +
                    "class SignUpInteractionCityMarketMap(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(SignUpInteractionCityMarketMap, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return SIGN_UP_INTERACTION_CITY_MARKET_MAP_DIALOG.copy()";

    private final SignInteractionCodeGenerationService signInteractionCodeGenerationService = new SignInteractionCodeGenerationService();
    private Sign sign;

    @Test
    void generateCodeForSignInteraction() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen")
                .map("city_market_map")
                .direction("up")
                .fileName("signInteraction.py").build();

        String builtCode = signInteractionCodeGenerationService.generateCodeForSignInteraction(sign);
        assertEquals(builtCodeTemplate, builtCode);

    }
}