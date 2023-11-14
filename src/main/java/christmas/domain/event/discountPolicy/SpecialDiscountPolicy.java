package christmas.domain.event.discountPolicy;

import christmas.domain.Date.Calender;
import christmas.domain.Date.Date;
import christmas.domain.order.Order;

import static christmas.constant.StringConstant.SPECIAL_DISCOUNT_POLICY;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private final int price;
    public SpecialDiscountPolicy() {
        this.price = -1000;
    }

    private boolean isSpecialDay(int day) {
        Calender findDay = Calender.findByDay(day);
        return findDay.isSpecialDay();
    }

    @Override
    public boolean isPriceOver(int price) {
        return price >= 10000;
    }

    @Override
    public int discount(Date date, Order order) {
        if (isPriceOver(order.getTotalPrice()) && isSpecialDay(date.getDay())) {
            return price;
        }
        return 0;
    }

    @Override
    public String getDiscountPolicy() {
        return SPECIAL_DISCOUNT_POLICY.getMessage();
    }
}
