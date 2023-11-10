package christmas.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.constant.ExceptionMessage.*;
import static christmas.constant.StringConstant.*;

public class InputUtil {
    private static final Map<String, Integer> map = new HashMap<>();

    public static int inputOrderDate(String date) {
        return stringToInt(date);
    }

    public static Map<String, Integer> inputOrderMenu(String input) {
        List<String> menus = splitByComma(input);
        return splitByHyphen(menus);
    }

    private static List<String> splitByComma(String s) {
        String[] split = s.split(COMMA.getMessage());
        Arrays.stream(split).forEach(InputUtil::validateCheckPattern);
        return List.of(split);
    }

    private static Map<String, Integer> splitByHyphen(List<String> list) {
        for (String element : list) {
            String[] split = element.split(HYPHEN.getMessage());
            validateDuplicationString(split[0]);
            int count = stringToInt(split[1]);
            map.put(split[0], count);
        }
        return map;
    }

    private static void validateDuplicationString(String s) {
        if (map.containsKey(s)) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }

    private static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_TYPE_MESSAGE.getMessage());
        }
    }

    private static void validateCheckPattern(String s) {
        Pattern pattern = Pattern.compile(REGEX.getMessage());
        Matcher matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }
}
