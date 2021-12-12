package rug.parras.parrascodegenerator.Map;

import org.springframework.stereotype.Service;

import java.util.List;

import static rug.parras.parrascodegenerator.Map.MapComponentGenerator.IMPORT_TEMPLATE;

@Service
public class MapCodeGenerationService {

    private final MapComponentGenerator mapComponentGenerator;

    public MapCodeGenerationService(MapComponentGenerator mapComponentGenerator) {
        this.mapComponentGenerator = mapComponentGenerator;
    }

    public String generateMap(Map map) {
        StringBuilder generatedMap = new StringBuilder();
        List<String> mapComponents = List.of(IMPORT_TEMPLATE,
                "\n\n" + mapComponentGenerator.generateTileMapList(map),
                "\n\n\n" + mapComponentGenerator.generateClass(map));
        mapComponents.forEach(component -> generatedMap.append(component));
        return generatedMap.toString();
    }
}
