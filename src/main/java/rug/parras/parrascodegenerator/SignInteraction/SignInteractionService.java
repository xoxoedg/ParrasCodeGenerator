package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.GeneratedCodeToFileConverter;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class SignInteractionService {

    public String createPythonCode(Sign sign) {
        String pythonSignCode  = String.format(Sign.getSIGNCODETEMPLATE(), sign.getDirection(), sign.getMap(),
                sign.getDirection(), sign.getMap(), createListName(sign));
        return pythonSignCode;
    }

    public String createListMap(Sign sign) {
        String pythonDictionary = String.format(createListName(sign) + " = " + Sign.getSIGNLISTTEXTTEMPLATE(), sign.getSignText());
        System.out.println(pythonDictionary);
        return pythonDictionary;

    }

    public String createListName(Sign sign) {
        String pythonDictionaryName = String.format(Sign.getSIGNLISTNAMETEMPLATE(), sign.getDirection().toUpperCase(), sign.getMap().toUpperCase(), sign.getSignText());
        return pythonDictionaryName;
    }

    public void createSignInteraction(Sign sign)  {

        try {
            GeneratedCodeToFileConverter converter = new GeneratedCodeToFileConverter(new FileWriter(sign.getFileName()));
            converter.createFile(sign.getFileName());
            converter.writeToFile(createListMap(sign));
            converter.appendToFile(createPythonCode(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

