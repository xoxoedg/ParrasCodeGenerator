package rug.parras.parrascodegenerator.Interactions;

public class InteractionValidationService {


    public boolean validateMapInput(String map) {
        return map.matches("[a-z]+(_[a-z]+)+_map");
    }


    public boolean validateAreaInput(String area) {
        return area.matches("[A-Z][a-z]+");
    }


    public boolean validateFileNameInput(String filename) {
        return filename.matches("[a-z]+\\.py");
    }
}
