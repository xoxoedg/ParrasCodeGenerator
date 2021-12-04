package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.InteractionValidationService;

import java.util.List;

@Service
public class TreasureInteractionValidationService extends InteractionValidationService {

    List<String> validItems = List.of("Potion", "Ether", "Serum", "Herb", "Tent", "Super Potion", "Super Ether");


    public boolean validateItem(String item) {
        String itemPattern = "^[A-Z][a-z]{3,6}(\\s[A-Z][a-z]{5})?";
        boolean IsPatternMatched = item.matches(itemPattern);
        return IsPatternMatched && validItems.contains(item);
    }

    public boolean validateAmount(int itemAmount) {
        String amountPattern = "^[1-9]";
        boolean IsPatternMatched = String.valueOf(itemAmount).matches(amountPattern);
        return itemAmount != 0 && IsPatternMatched;
    }
}



