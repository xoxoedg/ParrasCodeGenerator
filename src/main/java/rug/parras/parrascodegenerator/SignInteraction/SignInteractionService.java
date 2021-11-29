package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.GeneratedCodeToFileConverter;

import java.io.File;
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
            GeneratedCodeToFileConverter converter = new GeneratedCodeToFileConverter(sign.getFileName());
            converter.writeToFile(pythonCodeGenerationService.pythonCodeBuilder(sign));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

