package christmas.domain;

public enum Badge {
    NO_BADGE(null),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private String badge;

    Badge(String badge) {
        this.badge = badge;
    }

    public String getBadge() {
        if (this.isBadge()) {
            return badge;
        }
        return "없음";
    }

    public boolean isBadge() {
        return this != NO_BADGE;
    }
}
