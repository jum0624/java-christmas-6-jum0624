package christmas.service;

import christmas.discount.DiscountCalculator;
import christmas.domain.Badge;
import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.List;

public class DiscountService {

    private final DiscountCalculator discountCalculator;

    public DiscountService(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public DiscountCalculator discountEvent(Date date, Order order) {
        discountCalculator.discountChristmas(date, order);
        discountCalculator.discountWeekday(date, order);
        discountCalculator.discountWeekend(date, order);
        discountCalculator.discountSpecial(date, order);
        discountCalculator.discountGiveaway(order);
        return discountCalculator;
    }

    public String getProduct(Menu menu) {
        if (menu.isNotExist()) {
            return "없음";
        }
        return menu.getMenuName() + " 1개";
    }

    public List<String> getBenefitDetail(List<String> benefit) {
        if (benefit.size() == 0) {
            benefit.add("없음");
        }
        return benefit;
    }

    public int getAfterDiscountTotalPrice(Order order) {
        return order.getTotalPrice() + discountCalculator.getTotalDiscount();
    }

    public Badge badgeEvent(int totalDiscountPrice) {
        if (totalDiscountPrice >= 20000) {
            return Badge.SANTA;
        }
        if (totalDiscountPrice >= 10000) {
            return Badge.TREE;
        }
        if (totalDiscountPrice >= 5000) {
            return Badge.STAR;
        }
        return Badge.NO_BADGE;
    }
}
