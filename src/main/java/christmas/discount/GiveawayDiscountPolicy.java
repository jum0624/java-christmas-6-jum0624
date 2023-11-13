package christmas.discount;

import christmas.domain.Menu;
import christmas.domain.Order;

public class GiveawayDiscountPolicy implements DiscountPolicy {
    private Order order;

    private GiveawayDiscountPolicy(Order order) {
        this.order = order;
    }

    public static GiveawayDiscountPolicy discountPolicy(Order order) {
        return new GiveawayDiscountPolicy(order);
    }

    private boolean isDiscount() {
        return order.getTotalPrice() >= 120000;
    }

    @Override
    public boolean isPriceOver() {
        return order.getTotalPrice() >= 10000;
    }

    @Override
    public int discount() {
        if (isDiscount() && isPriceOver()) {
            return -25000;
        }
        return 0;
    }

    @Override
    public String toStringDiscount() {
        return "증정 이벤트";
    }

    public String getProduct() {
        return Menu.MENU12.getMenuName();
    }
}
