package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInteractionCodeGenerationService {

    private final SignComponentGenerator signComponentGenerator;

    @Autowired
    public SignInteractionCodeGenerationService(SignComponentGenerator signComponentGenerator) {
        this.signComponentGenerator = signComponentGenerator;
    }


    public String generateSignInteraction(Sign sign) {
        return SignComponentGenerator.SIGN_INTERACTION_IMPORT_TEMPLATE + "\n\n\n" + signComponentGenerator.createSignInteractionDialog(sign) +
                "\n\n\n" + signComponentGenerator.createSignInteractionClass(sign);
    }
}


