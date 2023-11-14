package christmas.domain.event.discountPolicy;

import christmas.domain.order.Date;
import christmas.domain.order.Menu;
import christmas.domain.order.Order;

import static christmas.constant.StringConstant.GIVEAWAY_DISCOUNT_POLICY;

public class GiveawayDiscountPolicy implements DiscountPolicy {

    private final int price;

    public GiveawayDiscountPolicy() {
        this.price = -25000;
    }

    private boolean isDiscount(int price) {
        return price >= 120000;
    }

    @Override
    public boolean isPriceOver(int price) {
        return price >= 10000;
    }

    @Override
    public int discount(Date date, Order order) {
        if (isDiscount(order.getTotalPrice()) && isPriceOver(order.getTotalPrice())) {
            order.updateOrder(Menu.CHAMPAGNE);
            return price;
        }
        return 0;
    }

    @Override
    public String getDiscountPolicy() {
        return GIVEAWAY_DISCOUNT_POLICY.getMessage();
    }
}
