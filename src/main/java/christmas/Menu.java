package christmas;

import java.util.Arrays;

public enum Menu {
    NOT_EXIST("존재하지 않는 음식", 0, null),
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

    private String menuName;
    private int price;
    private Category category;

    Menu(String menuName, int price, Category category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

    public static Menu findByMenuName(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst().orElse(NOT_EXIST);
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

    public boolean isNotExist() {
        return this == NOT_EXIST;
    }
}
