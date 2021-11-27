package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class SignInteractionService {

    public GeneratedSignResponse createResponse(Sign sign) {
        GeneratedSignResponse response = new GeneratedSignResponse();
        response.setGENERATEDPYTHONSIGNCODE(codeFormatter(sign));
        generatedCodeToPythonFile(sign);
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

    public void generatedCodeToPythonFile(Sign sign) {
        String fileName = "sign_interaction.py";
        File onFile = new File(fileName);
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(codeFormatter(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

