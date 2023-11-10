package christmas.util;

import java.util.List;

public class InputUtil {

    private static final String ERROR_INPUT_NUMBER_TYPE = "숫자만 입력해주세요.";
    private static final String COMMA = ",";
    public static int inputOrderDate(String date) {
        return stringToInt(date);
    }

    public static List<String> inputOrderMenu(String menus) {
        String[] menu = menus.split(COMMA);
        return List.of(menu);
    }

    private static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_TYPE);
        }
    }
}
