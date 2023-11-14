package christmas.domain.event;

import christmas.domain.event.discountPolicy.DiscountPolicy;
import christmas.domain.order.Date;
import christmas.domain.order.Menu;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.constant.StringConstant.GIVEAWAY_DISCOUNT_POLICY;

public class DiscountResult {
    private String giftMenu;
    private int totalDiscountPrice;
    private final Map<String, Integer> benefitDetails;
    private final List<DiscountPolicy> discountPolicies;

    public DiscountResult(List<DiscountPolicy> discountPolicies) {
        this.benefitDetails = new HashMap<>();
        this.giftMenu = Menu.NOT_EXIST.getMenuName();
        this.totalDiscountPrice = 0;
        this.discountPolicies = discountPolicies;
    }

    public void applyDiscount(Date date, Order order) {
        discountPolicies.forEach(discountPolicy -> {
            int discountPrice = discountPolicy.discount(date, order);
            String discountPolicyName = discountPolicy.getDiscountPolicy();
            totalDiscountPrice += discountPrice;
            saveBenefitDetails(discountPrice, discountPolicyName);
            isGiftMenu(discountPolicyName, discountPrice);
        });
    }

    private void saveBenefitDetails(int discountPrice, String discountPolicyName) {
        if (discountPrice != 0) {
            benefitDetails.put(discountPolicyName, discountPrice);
        }
    }

    private void isGiftMenu(String discountPolicyName, int discountPrice) {
        if (discountPolicyName.contains(GIVEAWAY_DISCOUNT_POLICY.getMessage()) && discountPrice != 0) {
            this.giftMenu = "샴페인 1개";
        }
    }

    public String getGiftMenu() {
        return giftMenu;
    }

    public Map<String, Integer> getBenefitDetails() {
        return benefitDetails;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }
}