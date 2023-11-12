package christmas.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.constant.ExceptionMessage.*;
import static christmas.constant.NumberConstant.MIN_MENU_COUNT;
import static christmas.constant.StringConstant.*;

public class InputUtil {
    private static Map<String, Integer> orders;

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
        orders = new HashMap<>();
        for (String element : list) {
            String[] split = element.split(HYPHEN.getMessage());
            validateDuplicationString(split[0]);
            int count = stringToInt(split[1]);
            validateNumberRange(count);
            orders.put(split[0], count);
        }
        return orders;
    }

    private static void validateDuplicationString(String s) {
        if (orders.containsKey(s)) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_MENU_COUNT.getNumber()) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MENU_COUNT_MESSAGE.getMessage());
        }
    }

    private static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
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
