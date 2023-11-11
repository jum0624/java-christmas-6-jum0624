package christmas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static christmas.constant.ExceptionMessage.ERROR_INPUT_ORDER_MESSAGE;
import static christmas.constant.NumberConstant.MAX_MENU_COUNT;

public class Order {
    private Map<String, Integer> order;
    private int total;
    private Map<Menu, Integer> orderedMenus;

    private Order(Map<String, Integer> order) {
        this.total = 0;
        createOrderedMenu(order);
        validateMenuCategory();
    }

    public static Order of(Map<String, Integer> order) {
        return new Order(order);
    }

    private void createOrderedMenu(Map<String, Integer> order) {
        orderedMenus = new HashMap<>();
        order.entrySet().forEach(menu -> {
            Menu orderedMenu = Menu.findByMenuName(menu.getKey());
            validateCheckMenu(orderedMenu);
            accountMenu(menu.getValue());
            orderedMenus.put(orderedMenu, menu.getValue());
        });
    }

    public Map<Menu, Integer> getOrderedMenus() {
        return orderedMenus;
    }

    private void validateCheckMenu(Menu menu) {
        if (menu.isNotExist()) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateTotalMenuCountRange() {
        if (this.total > MAX_MENU_COUNT.getNumber()) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateMenuCategory() {
        Set<Category> set = orderedMenus.keySet()
                .stream()
                .map(Menu::getCategory)
                .collect(Collectors.toSet());
        if (set.size() == 1 && set.contains(Category.DRINK)) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }

    private void accountMenu(int count) {
        this.total += count;
        validateTotalMenuCountRange();
    }
}
