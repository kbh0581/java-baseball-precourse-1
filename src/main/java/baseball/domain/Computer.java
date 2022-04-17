package baseball.domain;

public class Computer extends User {

    public Computer() {
        numberBaseBall = NumberBaseBall.createRandomBalls();
    }

    /**
     *  랜덤볼 생성하는 메서드
     * */
    public void changeBall() {
        NumberBaseBall randomBall = NumberBaseBall.createRandomBalls();
        while (randomBall.equals(numberBaseBall)) {
            randomBall = NumberBaseBall.createRandomBalls();
        }
    }
}
