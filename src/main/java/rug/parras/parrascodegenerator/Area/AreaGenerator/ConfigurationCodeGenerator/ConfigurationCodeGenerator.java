package rug.parras.parrascodegenerator.Area.AreaGenerator.ConfigurationCodeGenerator;

import org.springframework.stereotype.Component;

@Component
public class ConfigurationCodeGenerator  {

    private final String CONFIGURATION_CODE_TEMPLATE = "ALL_%S_MAPS=[]";

    public String generateConfigListCode(String areaName) {
        return String.format(CONFIGURATION_CODE_TEMPLATE, areaName.toUpperCase());
    }
}
