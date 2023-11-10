package christmas;

import java.time.LocalDate;

public class Date {

    private static final String ERROR_DAY_RANGE_MESSAGE = "1일 ~ 31일 이내의 값만 입력해주세요.";
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private int day;
    private LocalDate date;

    public Date(int day) {
        validateDayRange(day);
        saveDate(day);
    }

    public void saveDate(int day) {
        this.day = day;
        this.date = LocalDate.of(2023, 12, day);
    }

    public int findDateOfWeek() {
        return date.getDayOfWeek().getValue();
    }

    public int getDay() {
        return day;
    }

    private void validateDayRange(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new IllegalArgumentException(ERROR_DAY_RANGE_MESSAGE);
        }
    }
}
