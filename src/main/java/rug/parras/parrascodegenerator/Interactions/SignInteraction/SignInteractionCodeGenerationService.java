package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;

@Component
public class SignInteractionCodeGenerationService {

    public String generateCodeForSignInteraction(Sign sign) {
        return Sign.SIGN_INTERACTION_IMPORT_TEMPLATE + "\n\n\n" + createSignInteractionDialog(sign) + "\n\n\n" + createSignInteractionClass(sign);
    }

    private String createSignInteractionDialog(Sign sign) {
        return String.format(createSignInteractionListName(sign) + " = " + Sign.SIGN_INTERACTION_LIST_TEXT_TEMPLATE, sign.getSignText());
    }

    private String createSignInteractionClass(Sign sign) {
        return String.format(Sign.SIGN_INTERACTION_CLASS_TEMPLATE, StringUtils.capitalize(sign.getDirection()), MapParser.convertInputToMapName(sign),
                StringUtils.capitalize(sign.getDirection()), MapParser.convertInputToMapName(sign), createSignInteractionListName(sign));
    }

    private String createSignInteractionListName(Sign sign) {
        return String.format(Sign.SIGN_INTERACTION_LIST_NAME_TEMPLATE, sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
    }
}
