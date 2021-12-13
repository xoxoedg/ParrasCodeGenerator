package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignComponentGeneratorTest {

    private SignComponentGenerator signComponentGenerator;
    private Sign sign;

    @BeforeEach
    void setUp() {
        signComponentGenerator = new SignComponentGenerator();
        sign = Sign.builder().signText("Wuff")
                .area("rionnagen")
                .direction("up")
                .map("city_market_map")
                .build();

    }

    @Test
    void createSignInteractionDialog() {
        String expectedSignDialog = "SIGN_UP_INTERACTION_CITY_MARKET_MAP_DIALOG = ['Wuff']" ;
        String actualSignDialog = signComponentGenerator.createSignInteractionDialog(sign);
        assertEquals(expectedSignDialog, actualSignDialog);
    }

    @Test
    void createSignInteractionClass() {
        String expectedSignInteractionClass =
                "class SignUpInteractionCityMarketMap(AbstractInteractionDialog):\n" +
                        "\n" +
                        "    def __init__(self):\n" +
                        "        super(SignUpInteractionCityMarketMap, self).__init__([])\n" +
                        "\n" +
                        "    def define_speech(self):\n" +
                        "        return SIGN_UP_INTERACTION_CITY_MARKET_MAP_DIALOG.copy()";
        String actualSignInteractionClass = signComponentGenerator.createSignInteractionClass(sign);
        assertEquals(expectedSignInteractionClass, actualSignInteractionClass);


    }
}