package rug.parras.parrascodegenerator.Area.AreaGenerator.ItemInteractionFactory;

import lombok.Getter;
import org.springframework.stereotype.Component;
import rug.parras.parrascodegenerator.Area.AreaGenerator.AreaGeneratorInterfaces.FactoryCodeGenerator;

@Getter
@Component
public class ItemInteractionFactoryCodeGenerator implements FactoryCodeGenerator {

    private final String ITEM_INTERACTION_CODE_TEMPLATE =
            "class %sItemInteractionFactory:\n" +
                    "\n" +
                    "    @classmethod\n" +
                    "    def create_interaction(cls, hero):\n" +
                    "          pass";

    @Override
    public String generateFactoryCode(String areaName) {
        return String.format(ITEM_INTERACTION_CODE_TEMPLATE, areaName);
    }
}
