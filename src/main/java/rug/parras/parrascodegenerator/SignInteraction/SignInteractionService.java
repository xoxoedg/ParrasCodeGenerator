package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.GeneratedCodeToFileConverter;

import java.io.IOException;

@Service
public class SignInteractionService {

    public String createPythonCode(Sign sign) {
        String pythonSignCode  = String.format(Sign.getSIGNCODETEMPLATE(), sign.getDirection(), sign.getMap(),
                sign.getDirection(), sign.getMap(), createMapName(sign));
        return pythonSignCode;
    }

    public String createMapName(Sign sign) {
        String pythonDictionaryMapName = String.format(Sign.getSIGNMAPTEMPLATE(), sign.getDirection().toUpperCase(), sign.getMap().toUpperCase());
        return pythonDictionaryMapName;

    }

    public void createSignInteraction(Sign sign)  {
        GeneratedCodeToFileConverter converter = new GeneratedCodeToFileConverter();
        try {
            converter.createFile(sign.getFileName());
            converter.writeToFile(createPythonCode(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




//    public void generatedCodeToPythonFile(Sign sign) {
//        String fileName = "sign_interaction.py";
//        File onFile = new File(fileName);
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            writer.write(codeFormatter(sign));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

