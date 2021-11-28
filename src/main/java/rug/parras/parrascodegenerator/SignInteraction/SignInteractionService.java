package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.GeneratedCodeToFileConverter;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class SignInteractionService {

    public String createPythonCode(Sign sign) {
        String pythonSignCode  = String.format(Sign.getSIGNCODETEMPLATE(), sign.getDirection(), sign.getMap(),
                sign.getDirection(), sign.getMap(), createMapName(sign));
        return pythonSignCode;
    }

    public String createMap(Sign sign) {
        String pythonDictionary = String.format(createMapName(sign) + " = " + Sign.getSIGNMAPTEXTTEMPLATE(), sign.getSignText());
        System.out.println(pythonDictionary);
        return pythonDictionary;

    }

    public String createMapName(Sign sign) {
        String pythonDictionaryName = String.format(Sign.getSIGNMAPNAMETEMPLATE(), sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
        return pythonDictionaryName;
    }

    public void createSignInteraction(Sign sign)  {

        try {
            GeneratedCodeToFileConverter converter = new GeneratedCodeToFileConverter(new FileWriter(sign.getFileName()));
            converter.createFile(sign.getFileName());
            converter.writeToFile(createMap(sign));
            converter.appendToFile(createPythonCode(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

