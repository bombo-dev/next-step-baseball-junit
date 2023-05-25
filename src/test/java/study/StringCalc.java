package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class StringCalc {

    @DisplayName("문자열 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void stringCalc(String input) {
        String[] values = inputMethod(input);
        int total = solve(values);
        Assertions.assertThat(total).isEqualTo(10);
    }

    private String[] inputMethod(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        String[] values = inp.split(" ");
        return values;
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private int solve(String[] values) {
        int total = 0;
        char preOper = '+';

        for(String value : values) {
            char val = value.charAt(0);
            if(isOperation(val)) {
                preOper = val;
                continue;
            }
            int convertVal = val - '0';
            total = calc(total, convertVal, preOper);
        }

        return total;
    }

    private boolean isOperation(char ch){
        return !Character.isDigit(ch);
    }

    private int calc(int total, int value, char ch) {
        if(ch == '+')
            return total + value;
        if(ch == '*')
            return total * value;
        if(ch == '-')
            return total - value;

        return total / value;
    }
}
