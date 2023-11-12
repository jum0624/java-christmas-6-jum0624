package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.StringConstant;

public class InputView {
    public String inputDateView() {
        System.out.print(StringConstant.INPUT_DATE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputOrderView() {
        System.out.print(StringConstant.INPUT_MENUS_MESSAGE.getMessage());
        return Console.readLine();
    }
}
