package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Utils.FileOperationUtils;

import java.io.IOException;

@Service
public class SignInteractionService {

    SignInteractionCodeGenerationService signInteractionCodeGenerationService;

    @Autowired
    public SignInteractionService(SignInteractionCodeGenerationService signInteractionCodeGenerationService) {
        this.signInteractionCodeGenerationService = signInteractionCodeGenerationService;
    }

    public void createSignInteraction(Sign sign)  {

        try {
            FileOperationUtils converter = new FileOperationUtils("C:\\Users\\rugya\\Desktop\\Prod\\ParrasCodeGenerator\\src\\testPythonDir\\" + sign.getFileName());
            converter.writeToFile(signInteractionCodeGenerationService.generateCodeForSignInteraction(sign));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

