package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split()")
    void split() {
        String actual = "1,2";
        String[] result = actual.split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring()")
    void substring() {
        String actual = "(1,2)";
        assertThat(actual.substring(1, actual.length() - 1)).isEqualTo("1,2");
    }
}
