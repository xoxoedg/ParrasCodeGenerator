package rug.parras.parrascodegenerator.SignInteraction;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SignInteractionCodeGenerationService {

    public String generateCodeForSignInteraction(Sign sign) {
        return Sign.SIGN_IMPORT_TEMPLATE + "\n\n\n" + createSignInteractionDialog(sign) + "\n\n\n" + createSignInteractionClass(sign);
    }

    private String createSignInteractionDialog(Sign sign) {
        return String.format(createSignInteractionListName(sign) + " = " + Sign.SIGN_DIALOG_LIST_TEXT_TEMPLATE, sign.getSignText());
    }

    private String createSignInteractionClass(Sign sign) {
        return String.format(Sign.SIGN_DIALOG_CLASS_TEMPLATE, StringUtils.capitalize(sign.getDirection()), MapParser.convertInputToMapName(sign),
                StringUtils.capitalize(sign.getDirection()), MapParser.convertInputToMapName(sign), createSignInteractionListName(sign));
    }

    private String createSignInteractionListName(Sign sign) {
        return String.format(Sign.SIGN_DIALOG_LIST_NAME_TEMPLATE, sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
    }
}
