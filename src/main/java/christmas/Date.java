package christmas;

import java.time.LocalDate;

import static christmas.constant.ExceptionMessage.*;
import static christmas.constant.NumberConstant.*;

public class Date {
    private int day;
    private LocalDate date;

    public Date(int day) {
        validateDayRange(day);
        saveDate(day);
    }

    public void saveDate(int day) {
        this.day = day;
        this.date = LocalDate.of(YEAR.getNumber(), MONTH.getNumber(), day);
    }

    public int findDateOfWeek() {
        return date.getDayOfWeek().getValue();
    }

    public int getDay() {
        return day;
    }

    private void validateDayRange(int day) {
        if (day < MIN_DAY.getNumber() || day > MAX_DAY.getNumber()) {
            throw new IllegalArgumentException(ERROR_INPUT_DATE_MESSAGE.getMessage());
        }
    }
}
