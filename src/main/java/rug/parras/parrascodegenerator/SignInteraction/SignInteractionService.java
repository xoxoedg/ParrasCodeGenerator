package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

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
            FileOperationUtils converter = new FileOperationUtils("C:\\Users\\rugya\\Desktop\\Prod\\ParrasCodeGenerator\\src\\testPythonDir\\" + sign.getFileName());
            converter.writeToFile(pythonCodeGenerationService.generateCodeForSignInteraction(sign));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

