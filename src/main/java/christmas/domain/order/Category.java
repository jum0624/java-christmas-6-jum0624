package christmas.domain.order;

import java.util.Map;

public enum Category {
    NOT_CATEGORY, APPETIZER, MAIN, DESSERT, DRINK;

    public static boolean isOnlyDrink(Map<Menu, Integer> orders) {
        for (Menu menu : orders.keySet()
        ) {
            Category menuCategory = menu.getCategory();
            if (menuCategory == APPETIZER || menuCategory == MAIN || menuCategory == DESSERT) {
                return false;
            }
        }
        return true;
    }

}
