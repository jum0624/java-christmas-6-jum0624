package christmas.domain.order;

import java.util.HashMap;
import java.util.Map;

import static christmas.constant.ExceptionMessage.ERROR_INPUT_ORDER_MESSAGE;
import static christmas.constant.NumberConstant.MAX_MENU_COUNT;

public class Order {
    private Map<Menu, Integer> orders;
    private int totalCount;
    private int totalPrice;

    private Order(Map<String, Integer> order) {
        this.totalCount = 0;
        this.totalPrice = 0;
        createOrder(order);
        calculateTotalPrice();
        validateMenuCategory();
    }

    public static Order of(Map<String, Integer> order) {
        return new Order(order);
    }

    private void createOrder(Map<String, Integer> order) {
        orders = new HashMap<>();
        order.forEach((key, value) -> {
            Menu orderedMenu = Menu.findByMenuName(key);
            calculateMenuCount(value);
            orders.put(orderedMenu, value);
        });
    }

    public Map<Menu, Integer> getOrders() {
        return orders;
    }

    public int getDiscountTotalPrice(int discountPrice) {
        return getTotalPrice() + discountPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void calculateMenuCount(int count) {
        this.totalCount += count;
        validateTotalMenuCountRange();
    }

    private void calculateTotalPrice() {
        orders.entrySet().forEach(menu -> {
            Menu menuName = menu.getKey();
            Integer count = menu.getValue();
            totalPrice += menuName.getPrice() * count;
        });
    }

    public void updateOrder(Menu menu) {
        orders.put(menu, 1);
        totalPrice += menu.getPrice();
    }

    public int calculateCategoryCount(Category category) {
        return  orders.entrySet()
                .stream()
                .filter(order -> order.getKey().getCategory() == category)
                .mapToInt(Map.Entry::getValue).sum();
    }

    private void validateTotalMenuCountRange() {
        if (this.totalCount > MAX_MENU_COUNT.getNumber()) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }

    private void validateMenuCategory() {
        if (Category.isOnlyDrink(orders)) {
            throw new IllegalArgumentException(ERROR_INPUT_ORDER_MESSAGE.getMessage());
        }
    }
}
