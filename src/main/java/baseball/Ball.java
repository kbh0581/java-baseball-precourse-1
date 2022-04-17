package baseball;

public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (this.number > 9 || this.number < 1) {
            throw new IllegalArgumentException("볼의 숫자는 1~9를 가질 수 있습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
