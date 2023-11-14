package christmas.domain.event.discountPolicy;

import christmas.domain.order.Date;
import christmas.domain.order.Category;
import christmas.domain.order.Order;

import static christmas.constant.StringConstant.WEEKDAY_DISCOUNT_POLICY;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private final int price;

    public WeekdayDiscountPolicy() {
        this.price = -2023;
    }

    @Override
    public boolean isPriceOver(int price) {
        return price >= 10000;
    }

    @Override
    public int discount(Date date, Order order) {
        if (isPriceOver(order.getTotalPrice()) && isDateOfWeek(date.getDateOfWeek())) {
            return price * order.calculateCategoryCount(Category.DESSERT);
        }
        return 0;
    }

    @Override
    public String getDiscountPolicy() {
        return WEEKDAY_DISCOUNT_POLICY.getMessage();
    }

    private boolean isDateOfWeek(int dateOfWeek) {
        return dateOfWeek < 5 || dateOfWeek > 6;
    }
}
