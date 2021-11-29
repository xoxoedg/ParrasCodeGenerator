package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Component;

@Component
public class PythonCodeGenerationService {
    //generateCodeForSignInteraction
    public String pythonCodeBuilder(Sign sign) {
        return Sign.SIGNIMPORTEMPLATE  + "\n\n\n" + createList(sign) + "\n\n\n" + createClass(sign);
    }
    // Sign Dialog List
    private String createList(Sign sign) {
        return String.format(createListName(sign) + " = " + Sign.SIGNLISTTEXTTEMPLATE, sign.getSignText());
    }
    // SignInteractionClass
    private String createClass(Sign sign) {
        return String.format(Sign.getSIGN_CODE_TEMPLATE(), sign.getDirection(), sign.getMap(),
                sign.getDirection(), sign.getMap(), createListName(sign));
    }
    // Sign Dialog List Name
    private String createListName(Sign sign) {
        return String.format(Sign.SIGNLISTNAMETEMPLATE, sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
    }
}
