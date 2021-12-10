package rug.parras.parrascodegenerator.Utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringOperationUtils {

    public static String convertUnderscoreToCamelCase(String input) {
        return Arrays.stream(input.toLowerCase().split("_")).map(StringUtils::capitalize).collect(Collectors.joining());
    }
}
