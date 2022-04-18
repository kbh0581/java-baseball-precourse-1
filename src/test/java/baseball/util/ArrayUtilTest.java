package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayUtilTest {

    @Test
    @DisplayName("String 배열을 Integer 배열로 변경한다.")
    void stringToInteger() {
        String[] strings = {"3", "4", "5"};
        Integer[] integers = ArrayUtil.convertStringToInteger(strings);
        assertThat(integers[0]).isEqualTo(new Integer(3));
        assertThat(integers[1]).isEqualTo(new Integer(4));
        assertThat(integers[2]).isEqualTo(new Integer(5));

    }
}
