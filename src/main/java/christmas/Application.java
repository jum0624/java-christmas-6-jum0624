package christmas;

import christmas.controller.OrderController;
import christmas.discount.DiscountCalculator;
import christmas.service.DiscountService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DiscountCalculator discountCalculator = new DiscountCalculator();
        DiscountService discountService = new DiscountService(discountCalculator);
        OrderController orderController = new OrderController(new InputView(), new OutputView(), discountService);
        orderController.run();
    }
}
