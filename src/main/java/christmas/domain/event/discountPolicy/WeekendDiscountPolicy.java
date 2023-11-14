package christmas.domain.event.discountPolicy;

import christmas.domain.order.Date;
import christmas.domain.order.Category;
import christmas.domain.order.Order;

import static christmas.constant.StringConstant.WEEKEND_DISCOUNT_POLICY;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private final int price;

    public WeekendDiscountPolicy() {
        this.price = -2023;
    }

    @Override
    public boolean isPriceOver(int price) {
        return price >= 10000;
    }

    @Override
    public int discount(Date date, Order order) {
        if (isPriceOver(order.getTotalPrice()) && isDateOfWeek(date.getDateOfWeek())) {
            return price * order.calculateCategoryCount(Category.MAIN);
        }
        return 0;
    }

    @Override
    public String getDiscountPolicy() {
        return WEEKEND_DISCOUNT_POLICY.getMessage();
    }

    private boolean isDateOfWeek(int dateOfWeek) {
        return dateOfWeek == 5 || dateOfWeek == 6;
    }
}
