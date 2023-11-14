package christmas.config;

import christmas.domain.DiscountResult;
import christmas.domain.discountPolicy.*;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConfig {
    public DiscountResult discountPolicy() {
        List<DiscountPolicy> discountPolicies = new ArrayList<>();
        discountPolicies.add(new ChristmasDiscountPolicy());
        discountPolicies.add(new WeekdayDiscountPolicy());
        discountPolicies.add(new WeekendDiscountPolicy());
        discountPolicies.add(new SpecialDiscountPolicy());
        discountPolicies.add(new GiveawayDiscountPolicy());
        return new DiscountResult(discountPolicies);
    }
}
