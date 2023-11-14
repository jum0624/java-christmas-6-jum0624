package christmas;

import christmas.config.ApplicationConfig;
import christmas.controller.OrderController;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationConfig applicationConfig = new ApplicationConfig();
        OrderService orderService = new OrderService(applicationConfig.discountPolicy());
        OrderController orderController = new OrderController(new InputView(), new OutputView(), orderService);
        orderController.run();
    }
}
