package christmas.domain.order;

import java.util.Arrays;

import static christmas.constant.ExceptionMessage.ERROR_INPUT_ORDER_MESSAGE;

public enum Menu {
    NOT_EXIST("없음", 0, Category.NOT_CATEGORY),
    MENU1("양송이수프", 6000, Category.APPETIZER),
    MENU2("타파스", 5500, Category.APPETIZER),
    MENU3("시저샐러드", 8000, Category.APPETIZER),
    MENU4("티본스테이크", 55000, Category.MAIN),
    MENU5("바비큐립", 54000, Category.MAIN),
    MENU6("해산물파스타", 35000, Category.MAIN),
    MENU7("크리스마스파스타", 25000, Category.MAIN),
    MENU8("초코케이크", 15000, Category.DESSERT),
    MENU9("아이스크림", 5000, Category.DESSERT),
    MENU10("제로콜라", 3000, Category.DRINK),
    MENU11("레드와인", 60000, Category.DRINK),
    MENU12("샴페인", 25000, Category.DRINK);

    private final String menuName;
    private final int price;
    private final Category category;

    Menu(String menuName, int price, Category category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

    public static Menu findByMenuName(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage()));
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
