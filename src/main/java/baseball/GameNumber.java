package baseball;

import java.util.Random;

public class GameNumber {
    String number;

    public GameNumber() {
        initNumber();
    }

    private void initNumber() {
        number = createNumber();
    }

    private String createNumber() {
        int value = 0;
        try {
            Random random = new Random();
            value = (int) (random.nextDouble() * (999 - 100 + 1)) + 100;
            validNumber(value);
        } catch(RuntimeException e) {
            createNumber();
        }
        return String.valueOf(value);
    }

    private void validNumber(int value) {
        if(value < 100 || value > 999)
            throw new RuntimeException("3자리 숫자가 아닙니다." + value);
    }
}
