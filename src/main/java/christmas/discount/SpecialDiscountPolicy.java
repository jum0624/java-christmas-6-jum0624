package christmas.discount;

import christmas.domain.Calender;
import christmas.domain.Date;
import christmas.domain.Order;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private Calender day;
    private Order order;

    private SpecialDiscountPolicy(Date date, Order order) {
        this.day = Calender.findByDay(date.getDay());
        this.order = order;
    }

    public static SpecialDiscountPolicy discountPolicy(Date date, Order order) {
        return new SpecialDiscountPolicy(date, order);
    }

    @Override
    public boolean isPriceOver() {
        return order.getTotalPrice() >= 10000;
    }

    @Override
    public int discount() {
        if (isPriceOver() && day.isSpecialDay()) {
            return -1000;
        }
        return 0;
    }

    @Override
    public String toStringDiscount() {
        return "특별 할인";
    }
}
