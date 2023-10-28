package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = 0;
    }

    public void tryMove() {
        if (canMove()) {
            moves++;
        }
    }

    public void getPosition() {
        String name = this.name;
        String position = "-".repeat(this.moves);

        System.out.printf("%s : %s\n", name, position);
    }

    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    private boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) > 3);
    }

}
