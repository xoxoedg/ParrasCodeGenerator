package rug.parras.parrascodegenerator.Interactions.TreasureInteraction;

import org.springframework.stereotype.Service;
import rug.parras.parrascodegenerator.Interactions.ValidationService;

import java.util.List;

@Service
public class TreasureInteractionValidationService implements ValidationService {

    List<String> validItems = List.of("Potion", "Ether", "Serum", "Herb", "Tent", "Super Potion", "Super Ether");


    @Override
    public boolean validateMapInput(String map) {
        return map.matches("[a-z]+(_[a-z]+)+_map");
    }

    @Override
    public boolean validateAreaInput(String area) {
        return area.matches("[A-Z][a-z]+");
    }

    @Override
    public boolean validateFileNameInput(String filename) {
        return filename.matches("[a-z]+\\.py");
    }


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



