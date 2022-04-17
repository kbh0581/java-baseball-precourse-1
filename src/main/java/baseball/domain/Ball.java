package baseball.domain;

import java.util.Objects;

/**
 * BaseBall의 Ball의 해당되는 클래스
 * */
public class Ball {
    private final int number;
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RAGE = 9;


    public Ball(Integer number) {
        this.number = number;
        validate();
    }

    /**
     *  볼의 숫자는 1부터 ~ 9만 가질수 있다.
     * */
    private void validate() {
        if (this.number > MAX_NUMBER_RAGE || this.number < MIN_NUMBER_RANGE) {
            throw new IllegalArgumentException("볼의 숫자는 1~9를 가질 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Ball ball = (Ball) object;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Ball{"
                + "number=" + number
                + '}';
    }
}
