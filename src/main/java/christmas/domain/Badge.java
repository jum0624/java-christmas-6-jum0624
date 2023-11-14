package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 15000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NO_BADGE("없음", 0);

    private final String badge;
    private final int price;

    Badge(String badge, int price) {
        this.badge = badge;
        this.price = price;
    }

    public static Badge findBadge(int price) {
        return Arrays.stream(values())
                .filter(badge -> badge.price <= price)
                .findFirst().orElse(NO_BADGE);
    }

    public String getBadge() {
        return badge;
    }
}
