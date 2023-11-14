package christmas.constant;

public enum StringConstant {
    REGEX ("^[0-9가-힣-]*$"),
    COMMA(","),
    HYPHEN("-"),
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"),
    INPUT_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n"),
    INPUT_MENUS_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n"),
    PREVIEW_MESSAGE("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    PRINT_ORDER_MENU_MESSAGE("<주문 메뉴>\n"),
    PRINT_BEFORE_DISCOUNT_PRICE_MESSAGE("<할인 전 총주문 금액>\n"),
    PRINT_EVENT_MENU_MESSAGE("<증정 메뉴>\n"),
    PRINT_DISCOUNT_LIST_MESSAGE("<혜택 내역>\n"),
    PRINT_TOTAL_DISCOUNT_PRICE_MESSAGE("<총혜택 금액>\n"),
    PRINT_AFTER_DISCOUNT_TOTAL_PRICE_MESSAGE("<할인 후 예상 결제 금액>\n"),
    PRINT_EVENT_BADGE_MESSAGE("<12월 이벤트 배지>\n"),
    PRINT_CONTENT_AND_COUNT("%s %d개\n"),
    PRINT_PRICE("%,d원\n"),
    PRINT_DISCOUNT_LIST("%s: %,d원\n"),
    NO_VALUE("없음\n"),
    CHRISTMAS_DISCOUNT_POLICY("크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT_POLICY("평일 할인"),
    WEEKEND_DISCOUNT_POLICY("주말 할인"),
    SPECIAL_DISCOUNT_POLICY("특별 할인"),
    GIVEAWAY_DISCOUNT_POLICY("증정 이벤트");

    private String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
