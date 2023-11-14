package christmas.domain.Date;

import java.time.LocalDate;

import static christmas.constant.ExceptionMessage.ERROR_INPUT_DATE_MESSAGE;
import static christmas.constant.NumberConstant.*;

public class Date {
    private int day;
    private LocalDate date;

    private Date(String day) {
        validateNumberType(day);
        validateDayRange();
        saveDate();
    }

    public static Date of(String day) {
        return new Date(day);
    }

    private void saveDate() {
        this.date = LocalDate.of(YEAR.getNumber(), MONTH.getNumber(), day);
    }

    public int getDateOfWeek() {
        return date.getDayOfWeek().getValue();
    }

    public int getDay() {
        return day;
    }

    private void validateNumberType(String date) {
        try {
            this.day = Integer.parseInt(date);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_DATE_MESSAGE.getMessage());
        }
    }

    private void validateDayRange() {
        if (this.day < MIN_DAY.getNumber() || this.day > MAX_DAY.getNumber()) {
            throw new IllegalArgumentException(ERROR_INPUT_DATE_MESSAGE.getMessage());
        }
    }
}
