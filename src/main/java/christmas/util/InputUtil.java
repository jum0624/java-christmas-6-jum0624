package christmas.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil {

    private static final String ERROR_INPUT_NUMBER_TYPE_MESSAGE = "숫자만 입력해주세요.";
    private static final String ERROR_INPUT_COMMA_MESSAGE = "유효하지 않은 입력입니다.";
    private static final String REGEX = "^[0-9가-힣-]*$";
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";

    public static int inputOrderDate(String date) {
        return stringToInt(date);
    }

    public static Map<String, Integer> inputOrderMenu(String input) {
        List<String> menus = splitByComma(input);
        return splitByHyphen(menus);
    }

    private static List<String> splitByComma(String s) {
        String[] split = s.split(COMMA);
        Arrays.stream(split).forEach(InputUtil::validateCheckPattern);
        return List.of(split);
    }

    private static Map<String, Integer> splitByHyphen(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        list.stream().map(element -> element.split(HYPHEN)).forEach(split -> {
            int count = stringToInt(split[1]);
            map.put(split[0], count);
        });
        return map;
    }

    private static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_TYPE_MESSAGE);
        }
    }

    private static void validateCheckPattern(String s) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_INPUT_COMMA_MESSAGE);
        }
    }
}
