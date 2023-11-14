package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Date;
import christmas.domain.DiscountResult;
import christmas.domain.order.Order;
import christmas.service.OrderService;
import christmas.util.InputUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

import static christmas.constant.StringConstant.PREVIEW_MESSAGE;
import static christmas.constant.StringConstant.START_MESSAGE;

public class OrderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;

    public OrderController(InputView inputView, OutputView outputView, OrderService orderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        System.out.print(START_MESSAGE.getMessage());
        Date date = createDate();
        Order order = createOrder();
        System.out.println(PREVIEW_MESSAGE.getMessage());
        outputView.showOrder(order.getOrders());
        outputView.showBeforeDiscountTotalPrice(order.getTotalPrice());

        DiscountResult discountResult = orderService.discount(date, order);
        outputView.showGiveawayMenu(discountResult.getGiftMenu());
        outputView.showBenefitDetails(discountResult.getBenefitDetails());
        int totalDiscount = discountResult.getTotalDiscountPrice();
        outputView.showTotalDiscountPrice(totalDiscount);
        outputView.showAfterDiscountPrice(order.getDiscountTotalPrice(totalDiscount));
        Badge badge = orderService.getBadge(-totalDiscount);
        outputView.showEventBadge(badge);
    }

    public Date createDate() {
        try {
            String date = inputView.inputDateView();
            return Date.of(date);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return createDate();
        }
    }

    public Order createOrder() {
        try {
            String order = inputView.inputOrderView();
            Map<String, Integer> orders = InputUtil.inputOrderMenu(order);
            return Order.of(orders);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return createOrder();
        }
    }
}
