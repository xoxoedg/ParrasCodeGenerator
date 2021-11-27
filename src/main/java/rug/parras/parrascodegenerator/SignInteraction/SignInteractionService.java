package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Service;

@Service
public class SignInteractionService {

    public GeneratedSignResponse createResponse(Sign sign) {
        GeneratedSignResponse response = new GeneratedSignResponse();
        response.setGENERATEDPYTHONSIGNCODE(codeFormatter(sign));
        return response;
    }

    public String codeFormatter(Sign sign) {
        String pythonSignCode  = String.format(Sign.getSIGNCODETEMPLATE(), sign.getDirection(), sign.getMap(),
                sign.getDirection(), sign.getMap(), createMapName(sign));
        return pythonSignCode;
    }

    public String createMapName(Sign sign) {
        String pythonDictionaryMapName = String.format(Sign.getSIGNMAPTEMPLATE(), sign.getDirection().toUpperCase(), sign.getMap().toUpperCase());
        return pythonDictionaryMapName;

    }
}

