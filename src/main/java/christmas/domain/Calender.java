package christmas.domain;

import java.util.Arrays;

public enum Calender {
    NOT_DAY(0),
    DAY3(3),
    DAY10(10),
    DAY17(17),
    DAY24(24),
    DAY25(25),
    DAY31(31);

    private final int day;

    Calender(int day) {
        this.day = day;
    }

    public static Calender findByDay(int day) {
        return Arrays.stream(values())
                .filter(calender -> calender.day == day)
                .findFirst().orElse(NOT_DAY);
    }

    public boolean isSpecialDay() {
        return this != NOT_DAY;
    }
}
