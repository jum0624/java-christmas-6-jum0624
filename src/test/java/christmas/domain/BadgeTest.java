package christmas.domain;

import christmas.domain.event.Badge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {
    @Test
    @DisplayName("혜택 금액이 5000원 미만일 경우, 배지를 증정하지 않는다.")
    public void badgeEventTest1() throws Exception {
        // given
        int price = 3000;

        // when
        Badge badge = Badge.findBadge(price);

        // then
        Assertions.assertThat(badge).isEqualTo(Badge.NO_BADGE);
    }

    @Test
    @DisplayName("혜택 금액이 5000원 이상일 경우, 별 배지를 증정한다.")
    public void badgeEventTest2() throws Exception {
        // given
        int price1 = 5000;
        int price2 = 9900;

        // when
        Badge badge1 = Badge.findBadge(price1);
        Badge badge2 = Badge.findBadge(price2);

        // then
        Assertions.assertThat(badge1).isEqualTo(Badge.STAR);
        Assertions.assertThat(badge2).isEqualTo(Badge.STAR);
    }

    @Test
    @DisplayName("혜택 금액이 10000원 이상일 경우, 트리 배지를 증정한다.")
    public void badgeEventTest3() throws Exception {
        // given
        int price1 = 10000;
        int price2 = 14900;

        // when
        Badge badge1 = Badge.findBadge(price1);
        Badge badge2 = Badge.findBadge(price2);

        // then
        Assertions.assertThat(badge1).isEqualTo(Badge.TREE);
        Assertions.assertThat(badge2).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("혜택 금액이 15000원 이상일 경우, 산타 배지를 증정한다.")
    public void badgeEventTest4() throws Exception {
        // given
        int price1 = 15000;
        int price2 = 190000;

        // when
        Badge badge1 = Badge.findBadge(price1);
        Badge badge2 = Badge.findBadge(price2);

        // then
        Assertions.assertThat(badge1).isEqualTo(Badge.SANTA);
        Assertions.assertThat(badge2).isEqualTo(Badge.SANTA);
    }
}
