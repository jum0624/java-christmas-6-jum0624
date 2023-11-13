package christmas.discount;

import christmas.domain.Category;
import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.Map;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private Order order;
    private final int dateOfWeek;
    private final Map<Menu, Integer> orders;

    private WeekendDiscountPolicy(Date date, Order order) {
        this.order = order;
        this.dateOfWeek = date.getDateOfWeek();
        this.orders = order.getOrders();
    }

    public static WeekendDiscountPolicy discountPolicy(Date date, Order order) {
        return new WeekendDiscountPolicy(date, order);
    }

    @Override
    public boolean isPriceOver() {
        return order.getTotalPrice() >= 10000;
    }

    @Override
    public int discount() {
        for (Map.Entry<Menu, Integer> order : orders.entrySet()
        ) {
            if (isPriceOver() && isDateOfWeek() && isCategory(order.getKey())) {
                return -2023 * order.getValue();
            }
        }
        return 0;
    }

    @Override
    public String toStringDiscount() {
        return "주말 할인";
    }

    private boolean isDateOfWeek() {
        return dateOfWeek == 5 || dateOfWeek == 6;
    }

    private boolean isCategory(Menu menu) {
        return menu.getCategory() == Category.MAIN;
    }
}
