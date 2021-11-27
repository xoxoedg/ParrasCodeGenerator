package rug.parras.parrascodegenerator.SignInteraction;

import org.springframework.stereotype.Service;

@Service
public class SignInteractionService {

    public String printObje(Sign submittedSign) {
        return submittedSign.getArea() + submittedSign.getSignText() + submittedSign.getDirection() + submittedSign.getMap();

    }
}
