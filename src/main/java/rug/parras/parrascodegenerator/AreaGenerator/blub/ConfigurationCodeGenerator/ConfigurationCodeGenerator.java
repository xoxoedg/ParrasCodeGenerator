package rug.parras.parrascodegenerator.AreaGenerator.blub.ConfigurationCodeGenerator;

public class ConfigurationCodeGenerator  {

    private final String CONFIGURATION_CODE_TEMPLATE = "ALL_%s_MAPS=[]";

    public String generateConfigListCode(String areaName) {
        return String.format(CONFIGURATION_CODE_TEMPLATE, areaName);
    }
}
