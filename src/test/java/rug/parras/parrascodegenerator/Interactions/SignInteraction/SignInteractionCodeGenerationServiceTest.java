package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.junit.jupiter.api.Test;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.Sign;
import rug.parras.parrascodegenerator.Interactions.SignInteraction.SignInteractionCodeGenerationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignInteractionCodeGenerationServiceTest {

    private final String builtCodeTemplate1 =
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


    private final String builtCodeTemplate2 =
            "from common.dialogs.abstract_interaction_dialog import AbstractInteractionDialog\n" +
                    "\n" +
                    "\n" +
                    "SIGN_UP_INTERACTION_CITY_MARKET_FOREST_DIALOG = ['Danger']\n" +
                    "\n" +
                    "\n" +
                    "class SignUpInteractionCityMarketForest(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(SignUpInteractionCityMarketForest, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return SIGN_UP_INTERACTION_CITY_MARKET_FOREST_DIALOG.copy()";


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
        assertEquals(builtCodeTemplate1, builtCode);

    }

    @Test
    void generateCodeForSignInteraction2() {
        sign = Sign.builder()
                .signText("Danger")
                .area("Rionnagen Test")
                .map("City_MARKET_FOREST")
                .direction("up")
                .fileName("signinteraction.py").build();

        String builtCode = signInteractionCodeGenerationService.generateCodeForSignInteraction(sign);
        assertEquals(builtCodeTemplate2, builtCode);

    }
}