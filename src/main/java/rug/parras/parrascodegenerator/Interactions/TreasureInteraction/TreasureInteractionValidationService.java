package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.ValidationService;

import java.util.List;

@Service
public class TreasureInteractionValidationService implements ValidationService {

    List<String> validItems = List.of("Potion", "Ether", "Serum", "Herb", "Tent", "Super Potion", "Super Ether");
    String itemPattern = "^[A-Z][a-z]{3,6}(\\s[A-Z][a-z]{5})?";
    String amountPattern = "^[1-9]";

    @Override
    public boolean validateMapInput(String map) {
        return map.matches("[a-z]+(_[a-z]+)+");
    }

    @Override
    public boolean validateAreaInput(String area) {
        return  area.matches("[A-Z][a-z]+");
    }

    @Override
    public boolean validateFileNameInput(String filename) {
        return filename.matches("[a-z]+\\.py");
    }


    public boolean validateItem(String item) {
        boolean IsPatternMatched = item.matches(itemPattern);
        return IsPatternMatched && validItems.contains(item);
    }

    public boolean validateAmount(int itemAmount) {
        boolean IsPatternMatched = String.valueOf(itemAmount).matches(amountPattern);
        return itemAmount != 0 && IsPatternMatched;
    }
}



