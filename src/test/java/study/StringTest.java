package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("charAt()")
    void charAt(){
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt(), IndexOutOfBoundsException")
    void charAtEx() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
