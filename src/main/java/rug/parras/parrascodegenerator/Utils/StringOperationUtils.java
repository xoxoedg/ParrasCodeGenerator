package rug.parras.parrascodegenerator.Utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringOperationUtils {

    public static String convertUnderscoreToCamelCase(String input) {
        return Arrays.stream(input.toLowerCase().split("_")).map(StringUtils::capitalize).collect(Collectors.joining());
    }

    public static String convertSpaceToCamelCase(String input) {
        return Arrays.stream(input.toLowerCase().split(" ")).map(StringUtils::capitalize).collect(Collectors.joining());
    }

    public static String convertSpaceToLowercase(String input) {
        return Arrays.stream(input.toLowerCase().split(" ")).map(String::toLowerCase).collect(Collectors.joining());
    }
}
