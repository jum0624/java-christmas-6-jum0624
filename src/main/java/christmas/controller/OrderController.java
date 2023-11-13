package christmas.controller;

import christmas.discount.DiscountCalculator;
import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.service.DiscountService;
import christmas.util.InputUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

import static christmas.constant.StringConstant.*;

public class OrderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DiscountService discountService;

    public OrderController(InputView inputView, OutputView outputView, DiscountService discountService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.discountService = discountService;
    }

    public void run() {
        System.out.print(START_MESSAGE.getMessage());
        Date date = inputDate();
        Order order = inputOrder();

        System.out.println(PREVIEW_MESSAGE.getMessage());
        outputView.showOrder(order.getOrders());
        System.out.println();
        outputView.showBeforeDiscountTotalPrice(order.getTotalPrice());

        DiscountCalculator discountCalculator = discountService.discountEvent(date, order);
        Menu product = discountCalculator.getProduct();
        outputView.showGiveawayMenu(discountService.getProduct(product));
        Map<String, Integer> benefits = discountCalculator.getDiscountList();
        outputView.showBenefitDetails(discountService.getBenefitDetail(benefits));
        int totalDiscount = discountCalculator.getTotalDiscount();
        outputView.showTotalDiscountPrice(discountCalculator.getTotalDiscount());
        outputView.showAfterDiscountPrice(discountService.getAfterDiscountTotalPrice(order));
        outputView.showEventBadge(discountService.badgeEvent(-totalDiscount));
    }

    // 고객에게 날짜 정보 받아오기
    public Date inputDate() {
        try {
            String date = inputView.inputDateView();
            return Date.of(date);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return inputDate();
        }
    }

    // 고객에게 주문 정보 받아오기
    public Order inputOrder() {
        try {
            String order = inputView.inputOrderView();
            Map<String, Integer> orders = InputUtil.inputOrderMenu(order);
            return Order.of(orders);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return inputOrder();
        }

    }
}
