package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Interactions.common.MapParser;

@Component
public class SignComponentGenerator {

    public static final String SIGN_INTERACTION_CLASS_TEMPLATE =
            "class Sign%sInteraction%s(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(Sign%sInteraction%s, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return %s.copy()";

    public static final String SIGN_INTERACTION_LIST_NAME_TEMPLATE =
            "SIGN_%s_INTERACTION_%s_DIALOG";

    public static final String SIGN_INTERACTION_LIST_TEXT_TEMPLATE =
            "['%s']" ;

    public static final String SIGN_INTERACTION_IMPORT_TEMPLATE =
            "from common.dialogs.abstract_interaction_dialog import AbstractInteractionDialog";


    public String createSignInteractionDialog(Sign sign) {
        return String.format(createSignInteractionListName(sign) + " = " + SignComponentGenerator.SIGN_INTERACTION_LIST_TEXT_TEMPLATE, sign.getSignText());
    }

    public String createSignInteractionClass(Sign sign) {
        return String.format(SignComponentGenerator.SIGN_INTERACTION_CLASS_TEMPLATE, StringUtils.capitalize(sign.getDirection()), MapParser.convertInputToMapName(sign.getMap()),
                StringUtils.capitalize(sign.getDirection()), MapParser.convertInputToMapName(sign.getMap()), createSignInteractionListName(sign));
    }

    private String createSignInteractionListName(Sign sign) {
        return String.format(SignComponentGenerator.SIGN_INTERACTION_LIST_NAME_TEMPLATE, sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
    }
}



