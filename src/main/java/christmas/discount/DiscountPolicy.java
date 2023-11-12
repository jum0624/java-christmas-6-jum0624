package christmas.discount;

public interface DiscountPolicy {
    boolean isPriceOver();
    int discount();
    String toStringDiscount();
}
