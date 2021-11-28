package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.GeneratedCodeToFileConverter;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class SignInteractionService {

    PythonCodeGenerationService pythonCodeGenerationService;

    @Autowired
    public SignInteractionService(PythonCodeGenerationService pythonCodeGenerationService) {
        this.pythonCodeGenerationService = pythonCodeGenerationService;
    }

    public void createSignInteraction(Sign sign)  {

        try {
            GeneratedCodeToFileConverter converter = new GeneratedCodeToFileConverter(new FileWriter(sign.getFileName()));
            converter.createFile(sign.getFileName());
            converter.writeToFile(pythonCodeGenerationService.createList(sign));
            converter.appendToFile(pythonCodeGenerationService.createPythonCode(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

