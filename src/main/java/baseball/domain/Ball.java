package baseball.domain;

/**
 * BaseBall의 Ball의 해당되는 클래스
 * */
public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
        validate();
    }

    /**
     *  볼의 숫자는 1부터 ~ 9만 가질수 있다.
     * */
    private void validate() {
        if (this.number > 9 || this.number < 1) {
            throw new IllegalArgumentException("볼의 숫자는 1~9를 가질 수 있습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
