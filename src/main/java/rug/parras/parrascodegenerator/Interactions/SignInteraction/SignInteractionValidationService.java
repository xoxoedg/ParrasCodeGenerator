package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.InteractionValidationService;

import java.util.List;

@Service
public class SignInteractionValidationService extends InteractionValidationService {

    List<String> validDirections =  List.of("left", "right", "up", "down");

    public boolean validateDirectionInput(String direction) {
        return validDirections.contains(direction.toLowerCase());
    }

    public boolean validateSignText(String signText) {
        return signText.matches(".{20}");
    }

}
