package christmas.constant;

public enum NumberConstant {
    MIN_DAY(1),
    MAX_DAY(31),
    YEAR(2023),
    MONTH(12),
    MIN_MENU_COUNT(1),
    MAX_MENU_COUNT(20);
    private int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
