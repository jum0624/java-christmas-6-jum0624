package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Menu;

import java.util.List;
import java.util.Map;

import static christmas.constant.StringConstant.*;

public class OutputView {
    public void showOrder(Map<Menu, Integer> orders) {
        System.out.print(PRINT_ORDER_MENU_MESSAGE.getMessage());
        orders.entrySet().forEach(order ->
                System.out.printf(PRINT_CONTENT_AND_COUNT.getMessage(), order.getKey().getMenuName(), order.getValue()));
    }

    public void showBeforeDiscountTotalPrice(int price) {
        System.out.print(PRINT_BEFORE_DISCOUNT_PRICE_MESSAGE.getMessage());
        System.out.printf(PRINT_PRICE.getMessage(), price);
        System.out.println();
    }

    public void showGiveawayMenu(String menu) {
        System.out.print(PRINT_EVENT_MENU_MESSAGE.getMessage());
        System.out.println(menu);
        System.out.println();
    }

    public void showBenefitDetails(List<String> benefitDetails) {
        System.out.print(PRINT_DISCOUNT_LIST_MESSAGE.getMessage());
        benefitDetails.forEach(System.out::println);
        System.out.println();
    }

    public void showTotalDiscountPrice(int totalDiscountPrice) {
        System.out.print(PRINT_TOTAL_DISCOUNT_PRICE_MESSAGE.getMessage());
        System.out.printf(PRINT_PRICE.getMessage(), totalDiscountPrice);
        System.out.println();
    }

    public void showAfterDiscountPrice(int price) {
        System.out.print(PRINT_AFTER_DISCOUNT_TOTAL_PRICE_MESSAGE.getMessage());
        System.out.printf(PRINT_PRICE.getMessage(), price);
        System.out.println();
    }

    public void showEventBadge(Badge badge) {
        System.out.print(PRINT_EVENT_BADGE_MESSAGE.getMessage());
        System.out.println(badge.getBadge());
    }
}
