package christmas.discount;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private DiscountPolicy discountPolicy;
    private final Map<String, Integer> discountList;
    private int totalDiscount;
    private Menu product;

    public DiscountCalculator() {
        this.totalDiscount = 0;
        this.product = Menu.NOT_EXIST;
        this.discountList = new HashMap<>();
    }

    public void discountChristmas(Date date, Order order) {
        discountPolicy = ChristmasDiscountPolicy.discountPolicy(date, order);
        int discount = accountDiscount(discountPolicy);
        saveDiscountList(discount);
    }

    public void discountWeekday(Date date, Order order) {
        discountPolicy = WeekdayDiscountPolicy.discountPolicy(date, order);
        int discount = accountDiscount(discountPolicy);
        saveDiscountList(discount);
    }

    public void discountWeekend(Date date, Order order) {
        discountPolicy = WeekendDiscountPolicy.discountPolicy(date, order);
        int discount = accountDiscount(discountPolicy);
        saveDiscountList(discount);
    }

    public void discountSpecial(Date date, Order order) {
        discountPolicy = SpecialDiscountPolicy.discountPolicy(date, order);
        int discount = accountDiscount(discountPolicy);
        saveDiscountList(discount);
    }

    public void discountGiveaway(Order order) {
        discountPolicy = GiveawayDiscountPolicy.discountPolicy(order);
        int discount = accountDiscount(discountPolicy);
        saveDiscountList(discount);
        saveProduct(discount);
    }

    private int accountDiscount(DiscountPolicy discountPolicy) {
        int discount = discountPolicy.discount();
        totalDiscount += discount;
        return discount;
    }

    private void saveProduct(int discount) {
        if (discount != 0) {
            this.product = Menu.MENU12;
        }
    }

    private void saveDiscountList(int discount) {
        if (discount != 0) {
            discountList.put(discountPolicy.toStringDiscount(), discount);
        }
    }

    public Map<String, Integer> getDiscountList() {
        return discountList;
    }

    public Menu getProduct() {
        return product;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}
