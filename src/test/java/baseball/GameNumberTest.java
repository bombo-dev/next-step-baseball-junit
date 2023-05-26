package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class GameNumberTest {

    @Test
    @DisplayName("100 ~ 999 난수 생성")
    void createRandomValue() {
        for(int i = 0; i < 2000; i++) {
            GameNumber number = new GameNumber();
            assertThatCode(() -> {
                number.validNumber();
            }).doesNotThrowAnyException();
        }
    }

    @Test
    @DisplayName("난수 생성 테스트")
    void createRandom() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10000; i++) {
            list.add((int)(random.nextDouble() * (999 - 100 + 1)) + 100);
        }
        assertThat(list).contains(100, 999);
    }
}