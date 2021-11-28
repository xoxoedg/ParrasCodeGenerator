package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Component;

@Component
public class PythonCodeGenerationService {

    public String createPythonCode(Sign sign) {
        return String.format(Sign.getSIGNCODETEMPLATE(), sign.getDirection(), sign.getMap(),
                sign.getDirection(), sign.getMap(), createListName(sign));
    }

    public String createList(Sign sign) {
        return String.format(createListName(sign) + " = " + Sign.SIGNLISTTEXTTEMPLATE, sign.getSignText());

    }

    public String createListName(Sign sign) {
        return String.format(Sign.SIGNLISTNAMETEMPLATE, sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
    }
}
